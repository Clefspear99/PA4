import java.io.*;
import java.util.*;

public class PlagiarismDetector {

	private static final int SHINGLES = 3;
	private static final double PLAGIARISM_JACCARD_SIMILARITY_THRESHOLD = 0.7;

	public static void run(int[] primes, double threshHoldIn, String folderPath) throws IOException { // Task 3
		System.out.println("Running for: "+folderPath+ " Threshold: "+threshHoldIn);

		ArrayList<ArrayList<Integer>> allMinHashCodes = new ArrayList<>();
		ArrayList<String> docIDs = new ArrayList<>();

		ArrayList<String> currFileWords;
		ArrayList<Integer> minHashCodesInThisDoc;


		File folder = new File(folderPath);
		File[] allFiles = folder.listFiles();

		if(allFiles == null){
			folder=new File(System.getProperty("user.dir")+folderPath);
			allFiles=folder.listFiles();
		}

		Scanner scan;

		Character tempChar;
		StringBuilder stringBuilder;

		String[] splitUpString;

		boolean lastWasSpace=false;

		for (File curr: allFiles) {
			if(!curr.isFile() || !isTXT(curr.getName()))
				continue;

			scan = new Scanner(curr);
			scan.useDelimiter("");
			stringBuilder = new StringBuilder();


			//Having multiple spaces in a row was causing empty strings to be added as words which resulted
			//in all minhashes being 0.
			while(scan.hasNext()) {
				tempChar = scan.next().charAt(0);
				if(tempChar.isLetterOrDigit(tempChar)){
					stringBuilder.append(Character.toLowerCase(tempChar));
					lastWasSpace=false;
				}
				if(Character.isSpaceChar(tempChar) && !lastWasSpace){
					lastWasSpace=true;
					stringBuilder.append(Character.toLowerCase(tempChar));
				}

			}

			splitUpString=stringBuilder.toString().split(" ");
			currFileWords = new ArrayList<>(Arrays.asList(splitUpString));


			minHashCodesInThisDoc = new ArrayList<>();

			for(Integer prime: primes){
				minHashCodesInThisDoc.add(MinHash.minHashCode(currFileWords, SHINGLES, prime));
			}
			if(minHashCodesInThisDoc.get(0)==0 && minHashCodesInThisDoc.get(5)==0)
				MinHash.minHashCode(currFileWords, SHINGLES, primes[0]);

			allMinHashCodes.add(minHashCodesInThisDoc);
			docIDs.add(curr.getName());

		}

		HashSet codes;
		int k;

		for(int i =0; i<docIDs.size(); i++){
			for(int j =i+1; j<docIDs.size(); j++){
				k=0;

				codes = new HashSet();
				codes.addAll(allMinHashCodes.get(i));

				for(Integer code:allMinHashCodes.get(j)){
					if(codes.contains(code))
						k++;
				}

				if(k/(double) primes.length > threshHoldIn){
					System.out.println("Palgerism!!! File 1: "+docIDs.get(i)+" File 2: "+ docIDs.get(j));
				}

			}

		}

		System.out.println("");

	}

	public static void run(int[] primes,  String folderPath) throws IOException {
		run(primes, PLAGIARISM_JACCARD_SIMILARITY_THRESHOLD, folderPath);
	}

		public static ArrayList<String> getTXTs(String folderPath) throws FileNotFoundException {
		ArrayList<String> out = new ArrayList<>();

		File folder = new File(folderPath);
		ArrayList<File> allFiles = new ArrayList<>(Arrays.asList(folder.listFiles()));

		Scanner scan;
		Character tempChar;
		StringBuilder stringBuilder;

		for (File curr: allFiles) {
			if(!curr.isFile() || !isTXT(curr.getName())) {
				//allFiles.remove(curr);
				continue;
			}

			scan = new Scanner(curr);
			stringBuilder = new StringBuilder();

			while(scan.hasNext()) {
				tempChar = scan.next().charAt(0);
				if(tempChar.isLetterOrDigit(tempChar) || tempChar.equals(" "))
					stringBuilder.append(Character.toLowerCase(tempChar));
			}

			out.add(stringBuilder.toString());


		}
		return out;
	}

	public static boolean isTXT(String input){
		int length=input.length();
		String extension = input.substring(length-4, length);
		if(extension.equals(".txt"))
			return true;
		else
			return false;
	}



}
