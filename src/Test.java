import java.io.IOException;

public class Test {

	private static final int MAX_PRIME_LENGTH_IN_BITS = 24; // DO NOT EXCEED 30. Currently supported up to primes <= 2^30
	private static final int NUM_PRIMES = 20;
	private static final String DIRECTORY = "//Data/";//"PA4/Data/";

	public static void main(String[] args) throws IOException {

		int[] primes = PrimeGenerator.largePrimes(MAX_PRIME_LENGTH_IN_BITS, NUM_PRIMES);
		double threshHold=0.3;
		System.out.println("Threshold Value set to: "+threshHold+" Running for all sets!");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles100/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles1000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles2500/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles10000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setA/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setB/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setC/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setD/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setE/");

		System.out.println("-----------------------------------------------------------------------");
		primes = PrimeGenerator.largePrimes(MAX_PRIME_LENGTH_IN_BITS, NUM_PRIMES);
		threshHold=0.5;
		System.out.println("Threshold Value set to: "+threshHold+" Running for all sets!");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles100/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles1000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles2500/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles10000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setA/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setB/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setC/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setD/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setE/");

		System.out.println("-----------------------------------------------------------------------");
		primes = PrimeGenerator.largePrimes(MAX_PRIME_LENGTH_IN_BITS, NUM_PRIMES);
		threshHold=0.7;
		System.out.println("Threshold Value set to: "+threshHold+" Running for all sets!");
		//PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles100/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles1000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles2500/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles10000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setA/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setB/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setC/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setD/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setE/");


		System.out.println("-----------------------------------------------------------------------");
		primes = PrimeGenerator.largePrimes(MAX_PRIME_LENGTH_IN_BITS, NUM_PRIMES);
		threshHold=0.9;
		System.out.println("Threshold Value set to: "+threshHold+" Running for all sets!");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles100/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles1000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles2500/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "articles10000/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setA/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setB/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setC/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setD/");
		PlagiarismDetector.run(primes, threshHold, DIRECTORY + "setE/");
		System.out.println("-----------------------------------------------------------------------");



	}
}

//Sources (Basic Java stuff)
//https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
//https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html
//https://www.delftstack.com/howto/java/check-if-character-is-alphanumeric-java/
//https://stackoverflow.com/questions/4871051/how-to-get-the-current-working-directory-in-java
//https://stackoverflow.com/questions/7399482/java-lang-unsupportedoperationexception-at-java-util-abstractlist-removeunknown
