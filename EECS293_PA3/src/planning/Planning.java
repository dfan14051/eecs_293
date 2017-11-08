package planning;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import planning.Assignment.Dependency;
import planning.Assignment.Dependency.Type;

public class Planning {
	/*
	 * This method calculates the estimated delivery time given arguments with their
	 * durations and requirements. Returns -1 if there are cyclic requirements.
	 */
	// int calculateEstimatedDeliveryTime( List Assignments )
	public static int calculateEstimatedDeliveryTime(List<Assignment> assignments) {
		// List nodes;
		// nodes = loadGraphWithNodes(Assignments);
		List<Node> nodes = loadGraphWithNodes(assignments);

		// boolean change <- true;
		boolean change = true;
		// while(change)
		while (change) {
			// change <- false;
			change = false;
			// for each Assignment a addDependencies(a);
			for (Assignment assignment : assignments) {
				addDependencies(assignment, nodes, assignments);
			}
			// if containsCycle(nodes) return -1;
			if (containsCycle(nodes)) {
				return -1;
			}
		}
		// topologicalSort by max nodes
		nodes = topologicalSort(nodes);
		// return nodes[-1].time;
		return nodes.get(nodes.size() - 1).time;
	}

	// List loadGraphWithNodes( List Assignments ){
	private static List<Node> loadGraphWithNodes(List<Assignment> assignments) {
		// List nodes;
		List<Node> nodes = new LinkedList<Node>();
		// for each Assignment a
		for (Assignment assignment : assignments) {
			// beginA <- new Node with time 0 and nextNode null;
			Node beginAssignment = new Node(0);
			// endA <- new Node with time (beginA + A.duration) and nextNode null;
			Node endAssignment = new Node(beginAssignment.time + assignment.duration);
			// add endA to beginA.nextNodes;
			beginAssignment.nextNodes.add(endAssignment);
			// add beginA and endA to nodes;
			nodes.add(beginAssignment);
			nodes.add(endAssignment);
		}
		// return nodes;
		return nodes;
	}

	// boolean addDependencies( Assignment assignment )
	private static boolean addDependencies(Assignment assignment, List<Node> nodes, List<Assignment> assignments) {
		// for each Dependency d in assignment
		for (Dependency dependency : assignment.dependencies) {
			// if applyDependency(assignment, d) is false
			if (!applyDependencyType(assignment, dependency, dependency.type.assignmentAdjustment,
					dependency.type.dependencyAdjustment, nodes, assignments)) {
				// return false;
				return false;
			}
		}
		// return true;
		return true;
	}

	// boolean applyDependencyType( Assignment assignment,
	// Dependency dependency,
	// int assignmentAdjustment,
	// int dependencyAdjustment )
	private static boolean applyDependencyType(Assignment assignment, Dependency dependency, int assignmentAdjustment,
			int dependencyAdjustment, List<Node> nodes, List<Assignment> assignments) {
		// dependencyNodeIndex = getAssignmentNode(dependency.dependsOnAssignment) +
		// dependencyAdjustment;
		int dependencyNodeIndex = getAssignmentNode(assignments, dependency.dependsOnAssignment) + dependencyAdjustment;
		// assignmentNodeIndex = getAssignmentNode(assignment) + assignmentAdjustment;
		int assignmentNodeIndex = getAssignmentNode(assignments, assignment) + assignmentAdjustment;

		// if(nodes[dependencyNodeIndex].nextNodes has nodes[assignmentNodeIndex])
		// return false;
		if (nodes.get(dependencyNodeIndex).nextNodes.contains(nodes.get(assignmentNodeIndex))) {
			return false;
		}
		// else
		else {
			// nodes[dependencyNodeIndex].nextNodes add nodes[assignmentNodeIndex];
			nodes.get(dependencyNodeIndex).nextNodes.add(nodes.get(assignmentNodeIndex));
			// nodes[assignmentNodeIndex].time = nodes[dependencyNodeIndex].time;
			nodes.get(assignmentNodeIndex).time = nodes.get(dependencyNodeIndex).time;
			// if(assignmentAdjustment = 0) then
			// nodes[assignmentNodeIndex + 1].time = nodes[assignmentNodeIndex].time +
			// assignment.duration;
			if (assignmentAdjustment == 0) {
				nodes.get(assignmentNodeIndex + 1).time = nodes.get(assignmentNodeIndex).time + assignment.duration;
			}
			// return true;
			return true;
		}
	}

	// int getAssignmentNode( Assignment assignment )
	private static int getAssignmentNode(List<Assignment> assignments, Assignment assignment) {
		// int index = assignments get index of assignment
		int index = assignments.indexOf(assignment);
		// return 2 * index
		return 2 * index;
	}

	// Standard Topological Sort
	private static List<Node> topologicalSort(List<Node> nodes) {
		List<Node> graph = new LinkedList<Node>();

		Stack<Node> stack = new Stack<Node>();

		boolean[] visited = new boolean[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			visited[i] = false;
		}

		for (int i = 0; i < nodes.size(); i++) {
			if (visited[i] == false) {
				topologicalSortUtil(nodes.get(i), visited, stack, nodes);
			}
		}

		while (stack.empty() == false) {
			graph.add(stack.pop());
		}

		return graph;
	}

	private static void topologicalSortUtil(Node node, boolean[] visited, Stack<Node> stack, List<Node> nodes) {
		visited[nodes.indexOf(node)] = true;
		Node i;

		Iterator<Node> it = node.nextNodes.iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[nodes.indexOf(i)]) {
				topologicalSortUtil(i, visited, stack, nodes);
			}
		}
		stack.push(node);
	}

	// Standard algorithm to check for cycles
	private static boolean containsCycle(List<Node> nodes) {
		boolean[] visited = new boolean[nodes.size()];
		boolean[] recursionStack = new boolean[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			visited[i] = false;
			recursionStack[i] = false;
		}
		for (int i = 0; i < nodes.size(); i++) {
			if (containsCyclicUtil(nodes.get(i), visited, recursionStack, nodes)) {
				return true;
			}
		}
		return false;
	}

	private static boolean containsCyclicUtil(Node node, boolean[] visited, boolean[] recursionStack, List<Node> nodes) {
		if (visited[nodes.indexOf(node)] == false) {
			visited[nodes.indexOf(node)] = true;
			recursionStack[nodes.indexOf(node)] = true;
			if (checkRepeats(node, visited, recursionStack, nodes)) {
				return true;
			}
		}
		recursionStack[nodes.indexOf(node)] = false;
		return false;
	}

	private static boolean checkRepeats(Node node, boolean[] visited, boolean[] recursionStack, List<Node> nodes) {
		Node nextNode;
		Iterator<Node> it = node.nextNodes.iterator();
		while (it.hasNext()) {
			nextNode = it.next();
			if (!visited[nodes.indexOf(nextNode)] && containsCyclicUtil(node, visited, recursionStack, nodes)) {
				return true;
			} else if (recursionStack[nodes.indexOf(nextNode)]) {
				return true;
			}
		}
		return false;
	}

	public static class TestHook {
		public static List<Node> loadGraphWithNodes(List<Assignment> assignments) {
			return Planning.loadGraphWithNodes(assignments);
		}

		public static boolean addDependencies(Assignment assignment, List<Node> nodes, List<Assignment> assignments) {
			return Planning.addDependencies(assignment, nodes, assignments);
		}

		public static boolean applyDependencyType(Assignment assignment, Dependency dependency,
				int assignmentAdjustment, int dependencyAdjustment, List<Node> nodes, List<Assignment> assignments) {
			return Planning.applyDependencyType(assignment, dependency, assignmentAdjustment, dependencyAdjustment, nodes, assignments);
		}

		public static int getAssignmentNode(List<Assignment> assignments, Assignment assignment) {
			return Planning.getAssignmentNode(assignments, assignment);
		}

		public static List<Node> topologicalSort(List<Node> nodes) {
			return Planning.topologicalSort(nodes);
		}

		public static void topologicalSortUtil(Node node, boolean[] visited, Stack<Node> stack, List<Node> nodes) {
			Planning.topologicalSortUtil(node, visited, stack, nodes);
		}

		public static boolean containsCycle(List<Node> nodes) {
			return Planning.containsCycle(nodes);
		}

		public static boolean containsCyclicUtil(Node node, boolean[] visited, boolean[] recursionStack, List<Node> nodes) {
			return Planning.containsCyclicUtil(node, visited, recursionStack, nodes);
		}

		public static boolean checkRepeats(Node node, boolean[] visited, boolean[] recursionStack, List<Node> nodes) {
			return Planning.checkRepeats(node, visited, recursionStack, nodes);
		}
	}

}
