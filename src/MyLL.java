import java.lang.reflect.Array;
import java.util.Objects;

public class MyLL<T> {
    Node<T> head;
    private int size = 0;
    Node<T> tail;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if(size==0){
            head = tail = newNode;
        } else if(size == 1){
            tail = newNode;
            head.setNext(tail);
        }
        else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        // TODO: Implement this method - replace object with generic
        // Hint: Think about pointer manipulation order!

    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if(size==0){
            head = tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        // TODO: Implement this method - replace object with generic
        // Hint: Don't forget the empty list edge case!
        size++;
    }

    public void add(int index, T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Be careful with index bounds and pointer order!
        Node<T> newNode = new Node<>(data);
        if(index<=size) {
            if (size == 0) {
                addFirst(data);
            } else if (index == size) {
                addLast(data);
            } else {
                Node<T> beforeNode = head;
                for (int j = 1; j < index-1; j++) {
                    beforeNode = beforeNode.getNext();
                }
                newNode.setNext(beforeNode.getNext());
                beforeNode.setNext(newNode);
                size++;
            }
        }
    }

    public int removeFirst() {
        if(size==0){
            return -1;
        } else if (size == 1) {
            size--;
            head = null;
            tail = null;
            return 1;
        } else {
            size--;
            head = head.getNext();
            return 1;
        }
        // TODO: Implement this method
        // Hint: What happens when you remove the only element?
    }

    public int removeLast() {
        // TODO: Implement this method
        // Hint: What happens when you remove the only element?
        if(size==0){
            return -1;
        } else if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return 1;
        } else {
            Node<T> newNode = head;
            while (newNode.getNext() != tail) {
                newNode = newNode.getNext();
            }
            newNode.setNext(null);
            tail = newNode;
            size--;
            return 1;
        }

//        tail = null;
//        i--;
    }

    public boolean remove(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: You need the node BEFORE the one you're removing!
        if (head == null) {
            return false;
        } else if (size == 1 && head.getData() == data) {
            head = head.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
            return true;
        } else if(contains(data)){
            Node<T> nextNode = head.getNext();
            Node<T> headNode = head;
            int counter = 0;
            while (nextNode != null) {
                if (data.equals(nextNode.getData())) {
                    if(counter == 0 && headNode.equals(data)){
                        head = headNode.getNext();
                     if (nextNode == tail) {
                        tail = headNode;
                    } else {
                        headNode.setNext(nextNode.getNext());
                    }
                     size--;
                     return true;
                   }
                }   counter++;
                headNode = nextNode;
                nextNode = nextNode.getNext();
            }

        }
        return false;
    }
    public boolean removeFirstOccurrence(T data) {
        // TODO: Implement this method - replace object with generic
        if (head == null) {
            return true;
        } else if (size == 1 && head.getData().equals(data)) {
            head = head.getNext();
            return true;
        } else if(contains(data)){
            Node<T> nextNode = head.getNext();
            Node<T> headNode = head;
            int counter = 0;
            while (nextNode != null) {
                if (data.equals(nextNode.getData())) {
                    if(counter == 0 && headNode.equals(data)) {
                        head = headNode.getNext();
                        if (nextNode == tail) {
                            tail = headNode;
                            size--;
                            return true;
                        } else {
                            headNode.setNext(nextNode.getNext());
                            size--;

                            return true;
                        }

                    }
                    counter++;
                }
                headNode = nextNode;
                nextNode = nextNode.getNext();
            }
                }
        return false;
    }
    public boolean removeLastOccurrence(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the previous node of the last occurrence found
        if (head == null) {
            return false;
        } else if (size == 1 && head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        } else if(contains(data)){
            Node<T> nextNode = head.getNext();
            Node<T> headNode = head;
            int counter = 0;
            int index = 0;
            while (nextNode != null) {
                index = 0;
                if (data.equals(nextNode.getData())) {
                    if(counter == 0 && headNode.equals(data)) {
                        index = 0;
                    }
                    if (nextNode == tail) {
                        index = size-1;
                    } else {
                        index = counter;
                    }
                }
                counter++;
                headNode = nextNode;
                nextNode = nextNode.getNext();
            }
            nextNode = head.getNext();
            headNode = head;
            for(int x = 0; x < index; x++){
                headNode = nextNode;
                nextNode = nextNode.getNext();
            }
            if(index == size-1){
                tail = headNode;
            } else {
                headNode.setNext(nextNode.getNext());
            }
            size--;
            return true;
        }
        return false;
    }
    public void clear() {
        // TODO: Implement this method
        if (size == 1) {
            head = null;
        } else {
            Node<T> nextNode = head.getNext();
            for (int x = 1; x < size; x++) {
                head = null;
                nextNode = nextNode.getNext();
                if(x == size -1)
                    nextNode = null;
            }
        }
        size = 0;
        tail = null;
        head = null;
    }


    public T get(int index) {
        // TODO: Implement this method - replace object with generic
        // Hint: Use a loop counter to traverse the right number of steps
        if(index<0){
            return null;
        }
        if(index > size){
            return null;
        } else if(size==0) {
            return null;
        } else if(size == 1 && index == 0) {
            return getFirst();
        } else if(size == index) {
            return getLast();
        }
            Node<T> nextNode = head.getNext();
            Node<T> headNode = head;
            int b = 0;
            for(int x = 1; x < index; x++){
                nextNode = nextNode.getNext();
            }
            return nextNode.getData();
        }



    public T getFirst() {
        // TODO: Implement this method - replace object with generic
        // Hint: Check if list is empty first!
        if(size == 0){
            return null;
        }
        return head.getData();
    }

    public T getLast() {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse to the end or use tail pointer if available
        if(size == 0){
            return null;
        }
        return tail.getData();
    }


    public boolean contains(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse the entire list checking each node's data
        if (data.equals(null)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (data.equals(get(i))) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Keep track of current index while traversing
        // Return -1 if not found

        if(contains(data)){
            Node<T> nextNode = head;
            for(int x = 0; x < size ; x++){
                if(nextNode.getData().equals(data)){
                    return x;
                }
                nextNode = nextNode.getNext();
            }
        }
        return -1;

    }

    public int lastIndexOf(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the last found index during traversal
        if(data.equals(null)) {
            return -1;
        }
        else if(contains(data)){
            Node<T> nextNode = head;
            int returnOne = -1;
            for(int x = 0; x < size ; x++){
                if(data.equals(nextNode.getData())){
                    returnOne = x;
                }
                nextNode = nextNode.getNext();
            }
            return returnOne;
        }
        return -1;
    }


    public T set(int index, T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Similar to get(), but replace the data
        // Returns old value

        if(index<0){
            return null;
        } else if(index >= size){
            return null;
        } else {
            Node<T> nextNode;
            Node<T> oldNode = head;
            for(int x = 0; x < index ; x++){
                oldNode= oldNode.getNext();
            }
            T oldData = oldNode.getData();
            oldNode.setData(data);
            return oldData;
        }
    }

    public void replaceAll(T oldValue, T newValue) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse and replace all instances of old value with new
        if(newValue.equals(null) && oldValue.equals(null)) {
            if (size == 1) {
                if (head.getData().equals(oldValue))
                    head.setData(newValue);
            } else if (contains(oldValue)) {
                Node<T> nextNode = head.getNext();
                for (int x = 1; x < size; x++) {
                    if (nextNode.getData().equals(oldValue)) {
                        nextNode.setData(newValue);
                    }
                    nextNode = nextNode.getNext();
                }
            }
        }
    }

    public int size() {
        // TODO: Implement this method
        // Hint: Just return the size field!
        return size;
    }

    public boolean isEmpty() {
        // TODO: Implement this method
        // Hint: Check if size is 0 or head is null
        if(size == 0){
            return true;
        }
        else if(head.equals(null)){
            return true;
        }
        return false;
    }

    public void display() {
        // TODO: Implement this method
        // Goal: Print something like "[HEAD] -> 10 -> 20 -> 30 -> [NULL]"
        String display1 = new String("[HEAD]  ->");
        Node<T> nextNode = head;
        for(int x = 1; x < size ; x++){
            display1 = display1 + " " +  nextNode.getData();
            nextNode = nextNode.getNext();
        }
        display1 = display1 + " -> [TAIL]";
        System.out.println(display1);
    }

    public T[] toArray() {
        // TODO: Implement this method - replace object with generic
        // Hint: Create array of size() and populate while traversing
        T[] array = ((T[]) new Object[size]);
        Node<T> currentNode = head;
        for(int j = 0; j<size;j++){
            array[j] = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return array;
    }


}