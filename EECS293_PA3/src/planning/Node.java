package planning;

import java.util.HashSet;
import java.util.Set;

// class Node
public class Node {
//	int time;
	int time;
//	Set nextNodes;
	Set<Node> nextNodes;
	
	Node(int time){
		this.time = time;
		this.nextNodes = new HashSet<Node>();
	}
	
	Node(int time, Set<Node> nextNodes){
		this.time = time;
		this.nextNodes = nextNodes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nextNodes == null) ? 0 : nextNodes.hashCode());
		result = prime * result + time;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (nextNodes == null) {
			if (other.nextNodes != null)
				return false;
		} else if (!nextNodes.equals(other.nextNodes))
			return false;
		if (time != other.time)
			return false;
		return true;
	}

	public final int getTime() {
		return time;
	}

	public final Set<Node> getNextNodes() {
		return nextNodes;
	}

}
