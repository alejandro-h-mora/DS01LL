    public class Node<T> {
        T data;        // The actual value stored in this node
        Node<T> next;       // Reference to the next node in the list

        public Node(T data){
            this.data = data;
        }
        public T getData(){
            return data;
        }
        public void setData(T data){
            this.data = data;
        }
        public void setNext(Node<T> next){
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }
    }

