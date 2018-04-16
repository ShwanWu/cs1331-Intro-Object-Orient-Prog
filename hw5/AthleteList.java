
/**
 * Class to represent an Athlete.
 * @author ywu672
 * @version 1.0
 */
public class AthleteList<T extends Athlete> implements AthleteListInterface {

    private int size = INITIAL_CAPACITY;
    private Athlete[] elementData;


    //constructor
    public AthleteList() {
        elementData = new Athlete[size];
    }


    /**
     * Adds the specified element t to the BACK of the AthleteList.
     * If the AthleteList is full, it should be resized to twice its
     * current capacity. Note that if the AthleteList needs to be
     * resized, you should resize it and then carry on the add operation
     * as normal.
     * @throws IllegalArgumentException if the element to be added is null
     * @param t Element to be added to the AthleteList
     */
    public void add (Athlete t) throws IllegalArgumentException {

        if(size == elementData.length){
            Athlete[] newArray = new Athlete[size * 2];
            for(int i=0; i<elementData.length; i++){
                 newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
        elementData[size++] = t;
        size ++;
    }

    /**
     * Removes the element at the specified index, and returns it.
     * If the element isn't in the AthleteList, return null.
     * You should shift every element to the right of the removed
     * element one spot to the left, so that all the null elements are
     * in the back of the array. For example, suppose there's a list with
     * [1,2,3,4,5]. If we remove the element 2, we should have [1,3,4,5]
     * afterwards. If we then remove 4, the list should look like [1,3,5].
     * list.size() would now return 3.
     * The lists capacity would not change though.
     * @throws IndexOutOfBoundsException if the index is less than zero or is
     * greater than or equal to the number of elements in the AthleteList.
     * @param int index Index of the element to be removed.
     */
    public Athlete remove(int index) throws IndexOutOfBoundsException {

        if (elementData[index] == null) {
            size--;
            return null;
        } else {
            Athlete[] newArray = new Athlete[elementData.length];
            size--;
            for (int i = 0; i < index; i++) {
                newArray[i] = elementData[i];
            }
            for (int i = index; i < elementData.length - 1; i++) {
                newArray[i] = elementData[i + 1];
            }
            Athlete a = elementData[index];
            elementData = newArray;
            return a;
        }
    }

    /**
     * Returns the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is less than zero or
     * greater than or equal to the number of elements in the AthleteList.
     * @param  index Index of the element to be returned.
     */
    public Athlete get(int index) throws IndexOutOfBoundsException {
        return elementData[index];
    }

    /**
     * Removes all elements from the AthleteList, and resets it back
     * to its original capacity. Size should be zero after this happens.
     */
    public void clear() {
        elementData = new Athlete[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Returns the number of elements currently in the AthleteList
     * @return The number of elements in the AthleteList
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether this AthleteList is empty or not.
     * @return true if this AthleteList contains elements, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Prescribes training for the Athlete at the given
     * index via their train() method.
     * @throws IndexOutOfBoundsException if index is less than zero or greater
     * than or equal to the number of elements in the AthleteList.
     * @param index Index of the Athlete to be trained.
     */
    public void train(int index) throws IndexOutOfBoundsException {
        elementData[index].train();
    }

    /**
     * Prescribes rest for the Athlete at the given index via their rest()
     * method.
     * @throws IndexOutOfBoundsException if index is less than zero or greater
     * than or equal to the number of elements in the AthleteList.
     * @param index Index of the athlete to be rested.
     */
    public void rest(int index) throws IndexOutOfBoundsException {
        elementData[index].rest();
    }

    /**
     * Returns the ENTIRE backing array used in your implementation of
     * AthleteList without null elements.
     * @return Your backing array.
     */
    public Athlete[] asArray(){
        return elementData;
    }

}

