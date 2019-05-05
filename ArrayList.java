import java.util.*;
class ArrayList<E> {
  private E[] storage;
  private int index = 0;
  private int position = 0;
  public ArrayList(int size){
    storage = ArrayList.newArray(size);
  }
  public ArrayList(){
    this(10);
  }
  public void add(E thing){
    grow();
    storage[index++] = thing;
  }
  public E get(int in){
    return storage[in];
  }
  public void set(int in, E thing){
    while(storage.length < in + 5){
      growBy(5);
    }
    storage[in] = thing;
  }
  public int size(){
    return storage.length;
  }
  public void remove(int index){
    storage[index] = null;
  }
  private void grow(){
    if(index >= storage.length - 1){
      storage = ArrayList.newArray(storage.length + 5, storage);
    }
  }
  private void growBy(int size){
    storage = ArrayList.newArray(storage.length + size, storage);
  }
  @SafeVarargs
  private static <E> E[] newArray(int length, E... array)
  {
    return Arrays.copyOf(array, length);
  }
}
