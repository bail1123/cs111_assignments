
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PrefixExpressionEvaluator {

	static final String FILE = "data/expressions.txt";

	/** Reads lines of prefix expressions from a text file.
	 * 
	 * @param fileName Path to file containing expressions
	 * @return List of expressions
	 */
	public static List<String> readExpressions(String fileName) {
		List<String> list = new ArrayList<String>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			list =  (List) br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}


	/** Returns a queue of tokenized operators and operands.
	 * 
	 *  Splits a prefix expression on whitespaces. The operands and operators
	 * are placed in a queue. The tokens are enqueued in the same order
	 * as they appear in the expression. 
	 * 
	 * Valid operators are: + - * /
	 * Valid operands are integers
	 * 
	 * @param expression String of the mathematical expression
	 * 	For example, "+ 32 -3"
	 * @return Queue of tokens
	 * @throws IllegalArgumentException on invalid operators and operands
	 */
	public static Queue<String> tokenize(String expression) throws IllegalArgumentException {
		Queue<String> tokens = new Queue<String>();
		String[]potentialTokens = expression.split(" ");

		int size = potentialTokens.length;
		for(int i=0; i<size; i++){
			if(potentialTokens[i].equals("+")){
				tokens.enqueue(potentialTokens[i]);
			}
			else if(potentialTokens[i].equals("-")){
				tokens.enqueue(potentialTokens[i]);
			}
			else if(potentialTokens[i].equals("*")){
				tokens.enqueue(potentialTokens[i]);
			}
			else if(potentialTokens[i].equals("/")){
				tokens.enqueue(potentialTokens[i]);
			}
			else try{
				Integer.parseInt(potentialTokens[i]);
			} catch(NumberFormatException e) {
				System.err.println("NumberFormatException: " + e.getMessage());
			}

			tokens.enqueue(potentialTokens[i]);
		}

		return tokens;
	}


	/** Evaluates a given prefix expression
	 * 
	 * @param tokens Queue of operators and operands
	 * @return the result of evaluating the expression
	 * @throws IllegalArgumentException if the tokens do not form a valid expression
	 */
	public static double evaluate(Queue<String> tokens) throws IllegalArgumentException {
		if(tokens.peek() != "+" ||
				(tokens.peek() != "-")||
				(tokens.peek() != "*")||
				(tokens.peek() != "/"))
			System.out.println("This expression is invalid");

		List<String> myList = new ArrayList<String>();
		for(int i=0; i<3; i++){
			myList.add(tokens.dequeue());
		}
		
		return 0;
	}


	public static void main(String[] args){

	}

}
