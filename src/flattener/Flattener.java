package flattener;

import java.util.ArrayList;
import java.util.List;

public class Flattener {
	/**
	 * OVERVIEW: turn  nested arrays in a flat array
	 * 
	 * @param nestedArrays : nested arrays you want to make flat, type: Object[]
	 * @return type: Integer[]
	 * @throws( InvalidInputException ) nestedArrays!= Integer || nestedArrays!=Integer[]
	 * @throws ( NullException ) nestedArrays == null
	 */
	private static List<Integer> realCode(Object[] nestedArrays) throws InvalidInputException, NullException {
		if (nestedArrays == null) throw new NullException();
		// return type is a List because it is possible add elements at runtime. I can' t initialize an array because the size is unknown.
        List<Integer> flattenedArray = new ArrayList<>();
        for (Object i : nestedArrays) {
            if (i instanceof Integer) {
                flattenedArray.add((Integer) i );
            } else if( i instanceof Object[] ){
                flattenedArray.addAll(realCode((Object[]) i ));
            } else throw new InvalidInputException( "Input isn't an Integer nor a Integer[]" );
        }
        return flattenedArray;
    }
	
	public static Integer[] flatten (Object[] nestedArrays) throws InvalidInputException, NullException {
		//List.toArray( new Integer[0] ) makes the return type Integer[] instead of List<Integer>.
		return realCode( nestedArrays ).toArray( new Integer[0] );
	}
	
}