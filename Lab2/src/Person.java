/**
 * Created by Алина on 02.10.2016.
 */

public class Person {

    final int varA;
    final int varB;

    Person(int varA, int varB){
        this.varA = varA;
        this.varB = varB;
    }

    @Override
    final public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + varA;
        result = prime * result + varB;
        return result;
    }

    @Override
    final public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        if (varA != other.varA)
            return false;
        if (varB != other.varB)
            return false;
        return true;
    }

}
