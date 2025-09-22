import java.lang.reflect.Array;

public class MyLL<T> {
    Node<T> head;
    int i = 0;
    Node<T> tail;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            //create new node obj
            //head = newNode
            head = tail = newNode;
        }
        else {
            newNode.setNext(head);
            head = newNode;
        }
        i++;
        // TODO: Implement this method - replace object with generic
        // Hint: Think about pointer manipulation order!

    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = tail = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
        // TODO: Implement this method - replace object with generic
        // Hint: Don't forget the empty list edge case!
        i++;
    }

    public void add(int index, T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Be careful with index bounds and pointer order!
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = tail = newNode;
        } else if(index >= i){
            addLast(data);
        } else {
            Node<T> loopNode = head.getNext();
            Node<T> beforeNode = head;
            for(int j = 1; j<index; j++){
                if(j == index -1){
                    beforeNode.setNext(loopNode);
                    loopNode.setNext(loopNode.getNext());

                } else{
                    beforeNode = loopNode;
                    loopNode = loopNode.getNext();
                }

            }
        }

    }

    public int removeFirst() {
        if(head == null){
            i--;
            return -1;
        } else if (i == 1) {
            i--;
            head = null;
            return -1;
        } else{
            i--;
            head = head.getNext();
            return -1;
        }
        // TODO: Implement this method
        // Hint: What happens when you remove the only element?
    }

    public int removeLast() {
        // TODO: Implement this method
        // Hint: What happens when you remove the only element?
        if(head == null){
            return 1;
        } else if (i == 1) {
            head = null;
            return 1;
        } else{
            Node<T> nextNode = head.getNext();
            for(int x = 1; x < i ; x++){
                if(x == i - 1){
                    nextNode.setNext(null);
                    tail = nextNode;
                    return 1;
                } else{
                    nextNode = nextNode.getNext();
                }
            }
        }
//        tail = null;
//        i--;
        return -1;
    }

    public boolean remove(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: You need the node BEFORE the one you're removing!
        if (head == null) {
            return true;
        } else if (i == 1 && head.getData() == data) {
            head = head.getNext();
            return true;
        } else {
            Node<T> nextNode = head.getNext();
            Node<T> headNode = head;
            for (int x = 1; x < i; x++) {
                if (nextNode.getData() == data) {
                    headNode.setNext(nextNode.getNext());
                } else {
                    headNode.setNext(headNode.getNext());
                    nextNode = nextNode.getNext();
                }
            }
            return false;
        }
    }
    public boolean removeFirstOccurrence(T data) {
        // TODO: Implement this method - replace object with generic
        if (head == null) {
            return true;
        } else if (i == 1 && head.getData() == data) {
            head = head.getNext();
            return true;
        } else {
            Node<T> nextNode = head.getNext();
            Node<T> headNode = head;
            for (int x = 1; x < i; x++) {
                if (nextNode.getData() == data) {
                    headNode.setNext(nextNode.getNext());
                    return true;
                } else {
                    headNode.setNext(headNode.getNext());
                    nextNode = nextNode.getNext();
                }
            }
            return false;
        }
    }
    public boolean removeLastOccurrence(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the previous node of the last occurrence found
            if(head == null) {
                return true;
            }
            else if(i==1 && head.getData() == data){
                head = head.getNext();
                return true;
            } else {
                Node<T> nextNode = head.getNext();
                Node<T> headNode = head;
                int b = 0;
                for(int x = 1; x < i ; x++){
                    if(nextNode.getData() == data){
                        b++;
                    }
                        headNode.setNext(headNode.getNext());
                        nextNode = nextNode.getNext();
                }
                nextNode = head.getNext();
                headNode = head;
                for(int x = 1; x < b ; x++){
                    if(x==b-1) {
                        headNode.setNext(nextNode.getNext());
                    }
                }
                return false;
            }
    }

    public void clear() {
        // TODO: Implement this method
        if (i == 1) {
            head = null;
        } else {
            Node<T> nextNode = head.getNext();
            for (int x = 1; x < i; x++) {
                head = null;
                nextNode = nextNode.getNext();
                if(x == i -1)
                    nextNode = null;
            }
        }
        i = 0;
        tail = null;
        head = null;
    }


    public T get(int index) {
        // TODO: Implement this method - replace object with generic
        // Hint: Use a loop counter to traverse the right number of steps
        if(index >= i){
            return null;
        } else if(head == null) {
            return null;
        } else if(i == 1) {
            return head.getData();
        } else if(i == index) {
            return tail.getData();
        }
            Node<T> nextNode = head.getNext();
            Node<T> headNode = head;
            int b = 0;
            for(int x = 1; x < index; x++){
                if(x == i -1){
                    return nextNode.getData();
                }
                headNode.setNext(headNode.getNext());
                nextNode = nextNode.getNext();
            }
            return null;
        }



    public T getFirst() {
        // TODO: Implement this method - replace object with generic
        // Hint: Check if list is empty first!
        if(i == 0){
            return null;
        }
        return head.getData();
    }

    public T getLast() {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse to the end or use tail pointer if available
        return tail.getData();
    }


    public boolean contains(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse the entire list checking each node's data
        if(head == null){
            return false;
        } else if (i == 1) {
            if(head.getData()==data);
            return true;
        } else{
            Node<T> nextNode = head.getNext();
            for(int x = 1; x < i ; x++){
                if(nextNode.getData() == data){
                    return true;
                }
            }
            return false;
        }
    }

    public int indexOf(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Keep track of current index while traversing
        // Return -1 if not found
        if(head.getData()==data){
            return 0;
        }
        else if(contains(data)){
            Node<T> nextNode = head.getNext();
            for(int x = 1; x < i ; x++){
                if(nextNode.getData() == data){
                    return x;
                }
            }
        }
        return -1;

    }

    public int lastIndexOf(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the last found index during traversal
        if(head.getData()==data){
            return 0;
        }
        else if(contains(data)){
            Node<T> nextNode = head.getNext();
            int returnOne = 0;
            for(int x = 1; x < i ; x++){
                if(nextNode.getData() == data){
                    returnOne = x;
                }
            }
            return returnOne;
        }
        return -1;
    }


    public T set(int index, T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Similar to get(), but replace the data
        // Returns old value
        if(1 == index){
            head.setData(data);
            return head.getData();
        }
        else if(index <= i){
            Node<T> nextNode = head.getNext();
            for(int x = 1; x < i ; x++){
                if(x == index){
                    nextNode.setData(data);
                    return nextNode.getData();
                } else {
                    nextNode = nextNode.getNext();
                }

            }
        }
        return null;
    }

    public void replaceAll(T oldValue, T newValue) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse and replace all instances of old value with new
        if(i == 1){
            if(head.getData()==oldValue)
                head.setData(newValue);
        }
        else if(contains(oldValue)){
            Node<T> nextNode = head.getNext();
            for(int x = 1; x < i ; x++){
                if(nextNode.getData() == oldValue){
                    nextNode.setData(newValue);
                }
            }
        }
    }

    public int size() {
        // TODO: Implement this method
        // Hint: Just return the size field!
        return i;
    }

    public boolean isEmpty() {
        // TODO: Implement this method
        // Hint: Check if size is 0 or head is null
        if(i == 0){
            return true;
        }
        else if(head == null){
            return true;
        }
        return false;
    }

    public void display() {
        // TODO: Implement this method
        // Goal: Print something like "[HEAD] -> 10 -> 20 -> 30 -> [NULL]"
        String display1 = new String("[HEAD]  ->");
        Node<T> nextNode = head.getNext();
        for(int x = 1; x < i ; x++){
            display1 = display1 + " " +  nextNode.getData();
        }
    }

    public T[] toArray() {
        // TODO: Implement this method - replace object with generic
        // Hint: Create array of size() and populate while traversing
        T[] array = (T[]) new Object[i];
        Node<T> currentNode = head;
        for(int j = 0; j<i;j++){
            array[j] = currentNode.getData();
        }
        return array;
    }


}