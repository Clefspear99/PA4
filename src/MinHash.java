import java.util.ArrayList;

public class MinHash {

	private static int hashCode(String str, int prime) { // Task 1
		int n = str.length();
		int hashCode = 0;

		for(int i =n-1; i>=0; i--){
			//hashCode+= (int) Math.pow(2, i) * str.charAt(i);
			hashCode=(2*hashCode + str.charAt(i))% prime;
		}

		//return hashCode % prime;
		return hashCode;
	}

	public static int minHashCode(ArrayList<String> words, int shingles, int prime) { // Task 2
		int n = words.size();
		int minHash=-1;
		int currHash;
		String concat;
		StringBuilder stringBuilder;

		for(int i =0; i<=n-shingles; i++){
			stringBuilder = new StringBuilder();
			for(int j =i; j<shingles+i; j++)
				stringBuilder.append(words.get(j));

			currHash=hashCode(stringBuilder.toString(), prime);

			if(currHash<minHash || minHash==-1)
				minHash=currHash;
		}

		return minHash;
	}
}
