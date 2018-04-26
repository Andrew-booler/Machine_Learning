package dt.example;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import dt.core.DecisionTree;
import dt.core.DecisionTreeLearner;
import dt.core.Domain;
import dt.core.Example;
import dt.core.Problem;
import dt.core.Variable;
import dt.core.YesNoDomain;

/**
 * The restaurant WillWait example from AIMA Section 18.3, data
 * from file WillWait-data.txt.
 * <p>
 * Run and pass dataset filename on cmd-line.
 */
public class IrisProblem extends Problem {
	
	public IrisProblem() {
		super();
		// Input variables
		Domain yesNoDomain = new YesNoDomain();
		this.inputs.add(new Variable("Sepal length", new Domain("S", "MS", "L","ML")));
		this.inputs.add(new Variable("Sepal width", new Domain("S", "MS", "L","ML")));
		this.inputs.add(new Variable("Petal length", new Domain("S", "MS", "L","ML")));
		this.inputs.add(new Variable("Petal width", new Domain("S", "MS", "L","ML")));
		// Output variable
		this.output = new Variable("Class", new Domain("Iris-virginica","Iris Setosa","Iris Versicolour"));
	}
	
	public static void main(String[] args) throws IOException {
		Problem problem = new IrisProblem();
		problem.dump();
		Set<Example> examples = problem.readExamplesFromCSVFile(new File(args[0]));
		Set<Example> test_examples = examples;
		if(args.length==2) {
			 test_examples = problem.readExamplesFromCSVFile(new File(args[1]));
		}
		for (Example e : examples) {
			System.out.println(e);
		}
		DecisionTree tree = new DecisionTreeLearner(problem).learn(examples);
		System.out.println("start");
		tree.dump();
		System.out.println("dump");
		tree.test(examples);
		System.out.println("train set result");
		tree.test(test_examples);
		System.out.println("test set result");
	}

}

