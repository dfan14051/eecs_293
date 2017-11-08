package planning;

import java.util.HashSet;
import java.util.Set;

// class Assignment
public class Assignment {
//  int duration;
	int duration;
//  Set dependencies;
	Set<Dependency> dependencies;
	
	Assignment(int duration){
		this.duration = duration;
		this.dependencies = new HashSet<Dependency>();
	}
	
	Assignment(int duration, Set<Dependency> dependencies){
		this.duration = duration;
		this.dependencies = dependencies;
	}

//  class Dependency
	public static class Dependency {
//		enum type{ END-BEGIN, BEGIN-BEGIN, BEGIN-END, END-END }
		enum Type {
			ENDBEGIN(0, 1),
			BEGINBEGIN (0, 0),
			BEGINEND(1, 0),
			ENDEND(1, 1);
			
			int assignmentAdjustment;
			int dependencyAdjustment;
			Type(int assignmentAdjustment, int dependencyAdjustment) {
				this.assignmentAdjustment = assignmentAdjustment;
				this.dependencyAdjustment = dependencyAdjustment;
			}
		};
		
//		Assignment dependsOnAssignment
		Assignment dependsOnAssignment;
		Type type;
		
		Dependency(Assignment dependsOnAssignment, Type type){
			this.dependsOnAssignment = dependsOnAssignment;
			this.type = type;
		}
		
		public final Assignment getDependsOnAssignment() {
			return dependsOnAssignment;
		}

		public final Type getType() {
			return type;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dependsOnAssignment == null) ? 0 : dependsOnAssignment.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			Dependency other = (Dependency) obj;
			if (dependsOnAssignment == null) {
				if (other.dependsOnAssignment != null)
					return false;
			} else if (!dependsOnAssignment.equals(other.dependsOnAssignment))
				return false;
			if (type != other.type)
				return false;
			return true;
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dependencies == null) ? 0 : dependencies.hashCode());
		result = prime * result + duration;
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
		Assignment other = (Assignment) obj;
		if (dependencies == null) {
			if (other.dependencies != null)
				return false;
		} else if (!dependencies.equals(other.dependencies))
			return false;
		if (duration != other.duration)
			return false;
		return true;
	}
	
}
