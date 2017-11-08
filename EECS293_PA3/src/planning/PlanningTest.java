package planning;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import planning.Assignment.Dependency;
import planning.Assignment.Dependency.Type;
import planning.Planning.TestHook;

public class PlanningTest {
	List<Assignment> assignments;
	
	@Before
	public void setUp() {
		assignments = new ArrayList<Assignment>();
	}
	
	/*
	 * calculateEstimatedDeliveryTime Tests
	 */
	
	/**
	 * Structured Basis: Nominal case, boolean condition is always true: contains no cycles
	 * Boundary analysis: Nodes.size > 0
	 * Good data: nominal case: 4 items
	 */
	@Test
	public void testCalculateEstimatedDeliveryTimeNominal() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		a.dependencies.add(new Dependency(c, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(d, Type.BEGINEND));
		d.dependencies.add(new Dependency(c, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		int deliveryTime = Planning.calculateEstimatedDeliveryTime(assignments);
		assertEquals(14, deliveryTime);
	}
	
	/**
	 * Structured Basis: The list is empty, boolean condition is always true: contains no cycles
	 * Boundary analysis: Nodes.size <= 0
	 * Bad data: list is empty
	 */
	@Test
	public void testCalculateEstimatedDeliveryTimeEmpty() {
		Planning.calculateEstimatedDeliveryTime(assignments);
	}
	
	/**
	 * Structured Basis: Contains Cycles, boolean condition will be false
	 */
	@Test
	public void testCalculateEstimatedDeliveryTimeCycle() {
		Assignment a = new Assignment(3);
		Assignment b = new Assignment(3);
		a.dependencies.add(new Dependency(b, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(a, Type.BEGINEND));
		assignments.add(a);
		assignments.add(b);
		assertEquals(-1, Planning.calculateEstimatedDeliveryTime(assignments));
	}
	
	/*
	 * loadGraphWithNodes Tests
	 */
	
	/**
	 * Structured Basis: Nominal Case, goes through the for loop at least once
	 * Boundary analysis: Nodes.size > 0
	 * Good Data: Nominal Case: 2 items
	 */
	@Test
	public void testLoadGraphWithNodesNominal() {
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		assignments.add(c);
		assignments.add(d);
		List<Node> nodes = new LinkedList<Node>();
		Node cBeginNode = new Node(0);
		Node cEndNode = new Node(9);
		cBeginNode.nextNodes.add(cEndNode);
		Node dBeginNode = new Node(0);
		Node dEndNode = new Node(7);
		dBeginNode.nextNodes.add(dEndNode);
		nodes.add(cBeginNode);
		nodes.add(cEndNode);
		nodes.add(dBeginNode);
		nodes.add(dEndNode);
		List<Node> testNodes = TestHook.loadGraphWithNodes(assignments);
		for(int i = 0; i < nodes.size(); i++) {
			assertEquals(nodes.get(i), testNodes.get(i));
		}
	}
	
	/**
	 * Structured Basis: The list is empty, for loop condition is never called
	 * Boundary analysis: Nodes.size <= 0
	 * Bad Data: Empty input list
	 */
	@Test
	public void testLoadGraphWithNodesEmpty() {
		assertTrue(TestHook.loadGraphWithNodes(assignments).isEmpty());
	}
	
	/*
	 * addDependencies Tests
	 */
	
	/**
	 * Structured Basis: Nominal Case: For loop condition runs, dependencies are added
	 * Good Data: Nominal case
	 */
	@Test
	public void testAddDependenciesNominal() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		a.dependencies.add(new Dependency(c, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(d, Type.BEGINEND));
		d.dependencies.add(new Dependency(c, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		assertTrue(TestHook.addDependencies(a, nodes, assignments));
	}
	
	/**
	 * Structured Basis: For loop condition doesn't run
	 * Bad Data: Assignment has no dependencies
	 */
	@Test
	public void testAddDependenciesNoDependencies() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		b.dependencies.add(new Dependency(d, Type.BEGINEND));
		d.dependencies.add(new Dependency(c, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		assertTrue(TestHook.addDependencies(a, nodes, assignments));
	}
	
	/*
	 * applyDependencyType Tests
	 */
	
	/**
	 * Structured Basis: Nominal Case
	 * Dependency Node's nextNodes doesn't contain Assignment Node
	 * Assignment adjustment == 0
	 * Good Data: Nominal Case
	 */
	@Test
	public void testApplyDependencyTypeNominal0() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		Dependency dependency = new Dependency(b, Type.BEGINBEGIN);
		a.dependencies.add(dependency);
		a.dependencies.add(new Dependency(c, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(d, Type.BEGINEND));
		d.dependencies.add(new Dependency(c, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		assertTrue(TestHook.applyDependencyType(a, dependency, dependency.type.assignmentAdjustment, dependency.type.dependencyAdjustment, nodes, assignments));	
	}
	
	/**
	 * Structured Basis: Nominal Case
	 * Dependency Node's nextNodes doesn't contain Assignment Node
	 * Assignment adjustment != 0
	 * Good Data: Nominal Case
	 */
	@Test
	public void testApplyDependencyTypeNominal1() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		Dependency dependency = new Dependency(b, Type.BEGINBEGIN);
		a.dependencies.add(dependency);
		a.dependencies.add(new Dependency(c, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(d, Type.BEGINEND));
		d.dependencies.add(new Dependency(c, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		assertTrue(TestHook.applyDependencyType(a, dependency, 1, dependency.type.dependencyAdjustment, nodes, assignments));
	}
	
	/**
	 * Structured Basis: Dependency Node's nextNodes contains Assignment Node
	 * Good Data: Valid data, possible case
	 */
	@Test
	public void testApplyDependencyTypeContained() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		Dependency dependency = new Dependency(b, Type.BEGINBEGIN);
		a.dependencies.add(dependency);
		a.dependencies.add(new Dependency(c, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(d, Type.BEGINEND));
		d.dependencies.add(new Dependency(c, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		nodes.get(1).nextNodes.add(nodes.get(0));
		assertFalse(TestHook.applyDependencyType(a, dependency, dependency.type.assignmentAdjustment, dependency.type.dependencyAdjustment, nodes, assignments));
	}
	
	/**
	 * Bad Data: Empty lists
	 */
	@Test
	public void testApplyDependencyTypeEmpty() {
		List<Node> nodes = new LinkedList<Node>();
		assertFalse(TestHook.applyDependencyType(null, null, -1, -1, nodes, assignments));
	}
	
	/*
	 * getAssignmentNode Tests
	 */
	
	/**
	 * Structured basis: Nominal case
	 * Good data: Nominal case
	 */
	@Test
	public void testGetAssignmentNodeNominal() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		assertEquals(2, TestHook.getAssignmentNode(assignments, b));
	}
	
	/**
	 * Bad data: Empty assignment list
	 */
	@Test
	public void testGetAssignmentNodeBad() {
		Assignment a = new Assignment(5);
		assertEquals(0, TestHook.getAssignmentNode(assignments, a));
	}
	
	/*
	 * topologicalSort Tests
	 */
	
	/**
	 * Structured basis: Nominal case
	 * Good data: Nominal case
	 */
	@Test
	public void testTopologicalSortNominal() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		List<Node> sortedNodes = new LinkedList<Node>();
		sortedNodes.add(nodes.get(2));
		sortedNodes.add(nodes.get(0));
		sortedNodes.add(nodes.get(1));
		sortedNodes.add(nodes.get(3));
		List<Node> nodeList = TestHook.topologicalSort(nodes);
		for(int i = 0; i < sortedNodes.size(); i++) {
			assertEquals(sortedNodes.get(i), nodeList.get(i));
		}
	}
	
	/**
	 * Structured basis: Empty graph
	 * Bad data: empty graph
	 */
	@Test
	public void testTopologicalSortEmpty() {
		List<Node> nodes = new LinkedList<Node>();
		assertEquals(nodes, TestHook.topologicalSort(nodes));
	}
	
	/*
	 * topologicalSortUtil Tests
	 */
	/**
	 * Structured basis: Nominal Case
	 * iterator has next
	 * Not visited
	 * Good data: Nominal Case
	 */
	@Test
	public void testTopolologicalSortUtilNominal() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, false, false, false};
		Node node = nodes.get(1);
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		node = nodes.get(0);
		TestHook.topologicalSortUtil(node, visited, stack, nodes);
	}
	
	/**
	 * Structured basis: Empty stack case
	 * Bad data: empty stack
	 */
	@Test
	public void testTopologicalSortUtilEmpty() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, false, false, false};
		Node node = nodes.get(1);
		Stack<Node> stack = new Stack<Node>();
		node = nodes.get(0);
		TestHook.topologicalSortUtil(node, visited, stack, nodes);
	}
	
	/*
	 * containsCycle Tests
	 */
	/**
	 * Structured basis: Nominal Case, has nodes
	 * Has a cycle
	 * Good data: Nominal Case
	 */
	@Test
	public void testContainsCycleNominalCycle() {
		Assignment a = new Assignment(3);
		Assignment b = new Assignment(3);
		a.dependencies.add(new Dependency(b, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(a, Type.BEGINEND));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		assertTrue(TestHook.containsCycle(nodes));
	}
	
	/**
	 * Structured basis: Nominal Case, No cycle
	 * Good data: Nominal Case
	 */
	@Test
	public void testContainsCycleNominalNoCycle() {
		Assignment a = new Assignment(3);
		Assignment b = new Assignment(3);
		a.dependencies.add(new Dependency(b, Type.ENDBEGIN));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		assertFalse(TestHook.containsCycle(nodes));
	}
	
	/**
	 * Structured basis: No nodes
	 * Bad Data: Empty input list
	 */
	@Test
	public void testContainsCycleEmpty() {
		List<Node> nodes = new LinkedList<Node>();
		TestHook.containsCycle(nodes);
	}
	
	
	/*
	 * containsCyclicUtil Tests
	 */
	/**
	 * Structured basis: Nominal Case, 
	 * Visited is false
	 * Good data: Nominal Case
	 */
	@Test
	public void testContainsCyclicUtilNominalFalse() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		b.dependencies.add(new Dependency(a, Type.BEGINEND));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, false, false, false};
		boolean[] recStack = {false, false, false, false};
		Node node = nodes.get(1);
		assertTrue(TestHook.containsCyclicUtil(node, visited, recStack, nodes));
	}
	
	/**
	 * Structured basis: Nominal Case,
	 * Visited is true
	 * Good data: Nominal Case
	 */
	@Test
	public void testContainsCyclicUtilNominalTrue() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, true, false, false};
		boolean[] recStack = {false, true, false, false};
		Node node = nodes.get(1);
		assertFalse(TestHook.containsCyclicUtil(node, visited, recStack, nodes));
	}
	
	/**
	 * Bad data: Nodes is empty
	 */
	@Test
	public void testContainsCyclicUtilEmpty() {
		List<Node> nodes = new LinkedList<Node>();
		boolean[] visited = {false, false, false, false};
		boolean[] recStack = {false, false, false, false};
		assertFalse(TestHook.containsCyclicUtil(null, visited, recStack, nodes));
	}
	
	/*
	 * checkRepeats Tests
	 */
	/**
	 * Structured basis: Nominal
	 * Iterator has next
	 * Visited is true and containsCyclicUtil is true
	 * Good data: Nominal case
	 */
	@Test
	public void testCheckRepeatsNominal() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINEND));
		b.dependencies.add(new Dependency(a, Type.ENDBEGIN));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, true, false, false};
		boolean[] recStack = {false, true, false, false};
		Node node = nodes.get(1);
		assertTrue(TestHook.checkRepeats(node, visited, recStack, nodes));
	}
	
	/**
	 * Structured basis: Nominal
	 * Iterator has next
	 * Visited is true and containsCyclicUtil is false
	 * recursiveStack is true
	 * Good data: Nominal case
	 */
	@Test
	public void testCheckRepeatsRecStackTrue() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		b.dependencies.add(new Dependency(a, Type.BEGINEND));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, false, false, false};
		boolean[] recStack = {false, false, false, false};
		Node node = nodes.get(1);
		assertTrue(TestHook.checkRepeats(node, visited, recStack, nodes));
	}
	
	/**
	 * Structured basis: Nominal
	 * Iterator has next
	 * Visited is false and containsCyclicUtil is *
	 * recursiveStack is false
	 * Good data: Nominal case
	 */
	@Test
	public void testCheckRepeatsNominalVisited() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		b.dependencies.add(new Dependency(a, Type.BEGINEND));
		assignments.add(a);
		assignments.add(b);
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, false, false, false};
		boolean[] recStack = {false, false, false, false};
		Node node = nodes.get(1);
		assertFalse(TestHook.checkRepeats(node, visited, recStack, nodes));
	}
	
	/**
	 * Bad data: Nodes is empty
	 */
	@Test
	public void testCheckRepeatsEmpty() {
		List<Node> nodes = TestHook.loadGraphWithNodes(assignments);
		boolean[] visited = {false, false, false, false};
		boolean[] recStack = {false, false, false, false};
		assertFalse(TestHook.checkRepeats(null, visited, recStack, nodes));
	}
	
	/*
	 * Stress Test
	 */
	@Test
	public void stressTest() {
		for(int i = 0; i < 10000; i++) {
			Assignment assignment = new Assignment((int)(Math.random()*1000));
			assignments.add(assignment);
		}
		for(int i = 0; i < 10000; i++) {
			Assignment assignment = assignments.get((int)(Math.random()*10000));
			assignment.dependencies.add(randomDependency());
		}
		
		Planning.calculateEstimatedDeliveryTime(assignments);
		
	}
	
	private Dependency randomDependency() {
		Double rand = Math.random();
		if(rand < .25) {
			int index = ((int)(Math.random()*1000));
			return new Dependency(assignments.get(index), Dependency.Type.BEGINBEGIN);
		}
		else if (rand <.5) {
			int index = ((int)(Math.random()*1000));
			return new Dependency(assignments.get(index), Dependency.Type.BEGINEND);
		}
		else if (rand < .75) {
			int index = ((int)(Math.random()*1000));
			return new Dependency(assignments.get(index), Dependency.Type.ENDBEGIN);
		}
		else {
			int index = ((int)(Math.random()*1000));
			return new Dependency(assignments.get(index), Dependency.Type.ENDEND);
		}
	}

}
