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
public class HouseVoteProblem extends Problem {
	
	public HouseVoteProblem() {
		super();
		// Input variables

		this.inputs.add(new Variable("handicapped-infants", new Domain("y", "n","?")));
		this.inputs.add(new Variable("water-project-cost-sharing",new Domain("y", "n","?")));
		this.inputs.add(new Variable("adoption-of-the-budget-resolution", new Domain("y", "n","?")));
		this.inputs.add(new Variable("physician-fee-freeze", new Domain("y", "n","?")));
		this.inputs.add(new Variable("el-salvador-aid", new Domain("y", "n","?")));
		this.inputs.add(new Variable("religious-groups-in-schools", new Domain("y", "n","?")));
		this.inputs.add(new Variable("anti-satellite-test-ban", new Domain("y", "n","?")));
		this.inputs.add(new Variable("aid-to-nicaraguan-contras", new Domain("y", "n","?")));
		this.inputs.add(new Variable("mx-missile",new Domain("y", "n","?")));
		this.inputs.add(new Variable("immigration", new Domain("y", "n","?")));
		this.inputs.add(new Variable("synfuels-corporation-cutback", new Domain("y", "n","?")));
		this.inputs.add(new Variable("education-spending", new Domain("y", "n","?")));
		this.inputs.add(new Variable("superfund-right-to-sue", new Domain("y", "n","?")));
		this.inputs.add(new Variable("crime", new Domain("y", "n","?")));
		this.inputs.add(new Variable("duty-free-exports", new Domain("y", "n","?")));
		this.inputs.add(new Variable("export-administration-act-south-africa", new Domain("y", "n","?")));
		
		// Output variable
		this.output = new Variable("Class", new Domain("democrat","republican"));
	}
	
	public static void main(String[] args) throws IOException {
		Problem problem = new HouseVoteProblem();
		problem.dump();
		Set<Example> examples = problem.readExamplesFromCSVFile(new File(args[0]));
		for (Example e : examples) {
			System.out.println(e);
		}
		DecisionTree tree = new DecisionTreeLearner(problem).learn(examples);
		System.out.println("start");
		tree.dump();
		System.out.println("dump");
		tree.test(examples);
		System.out.println("finish");
	}

}

