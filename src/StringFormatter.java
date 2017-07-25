
import java.util.*;

public class StringFormatter {
	String inputString = "";
	
	
	public StringFormatter(String s) {
		inputString = s;
	}
	
	public String[] toSplit(String in) {
		String[] words = in.split(" ");
		return words;
	}
	
	public void toWord() {
		String[] words = toSplit(inputString);
		int length = words.length;

		ArrayList<List> obj = new ArrayList<List>();
		
		for(int j = 0; j < length; j++) {
			ArrayList<Word> arr = new ArrayList<Word>();		//create an array to filter by first letter
			char temp = words[j].charAt(0);					//take a first letter in the i-word
			
			for(int i = 0; i < length; i++) {
				int len = words[i].length();
				String repr = words[i];
				if(words[i].charAt(0)==temp) {
					arr.add(new Word(len, repr));	
				}		
			}
			Collections.sort(arr, new ComparatorCombined());	//first sort by length of word and sort by alphabet queue after this
			if(arr.size() > 1) {
				obj.add(arr);
			}
		}
		Set<List> setWord = new TreeSet<List>(new ComparatorLiter());
		Collections.sort(obj, new ComparatorLiter());
		setWord.addAll((Collection<? extends ArrayList>) obj);
		
		// don't ask me, why this loop so ugly - That's what the Eye told me.
        
		for(Object o: setWord){
			System.out.print(((Word) ((ArrayList<List>) o).get(0)).getRepresent().charAt(0) + "=" + o.toString() + ", ");
		}
	}	
}
 
class Word{
	String represent;
	int length;
	
	public Word(int l, String r) {
		length = l;
		represent = r;
	}
	
	public String getRepresent(){
        return this.represent;
    }
    
    public int getLength(){
        return this.length;
    }
    public String toString() {
        return this.represent;
    }
}


class ComparatorLiter implements Comparator<List>{
    @Override
    public int compare(List o1, List o2) {
        char chr1 = ((Word) o1.get(0)).getRepresent().charAt(0);
        char chr2 = ((Word) o2.get(0)).getRepresent().charAt(0);
        
        String str1 = String.valueOf(chr1);
        String str2 = String.valueOf(chr2);
        
        return str1.compareTo(str2);
    }
}

class ComparatorCombined implements Comparator<Word>{
    @Override
    public int compare(Word o1, Word o2) {
        String str1 = o1.getRepresent();
        String str2 = o2.getRepresent();
        
        int flag = o2.getLength() - o1.getLength();
        		
        // if we get zero, lets sort by name 
        if(flag == 0) {
        	return str1.compareToIgnoreCase(str2);
        }
        return flag;
    }
}
