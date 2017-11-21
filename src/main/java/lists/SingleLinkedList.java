package lists;

import exceptions.WrongIndexException;

import java.util.NoSuchElementException;

/**
 * Created by komputer on 21.11.2017.
 */
public class SingleLinkedList<E extends Comparable<E>> {

    private class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> element){
            this.next=element;
        }
        public void setElement(E element){
            this.element=element;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    int size = 0;

    public SingleLinkedList(){
        head=null;
        tail=null;
    }
    public SingleLinkedList(E element){
        Node<E> node = new Node<E>(element,null);
        head = node;
        tail = node;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    private void addFirstElement(Node<E> node){
        head = node;
        tail = node;
    }

    public void addElementAtEnd(E element){
        Node<E> node = new Node<E>(element,null);
        if(size>0){
            tail.setNext(node);
            tail=node;
            size++;
        }else
            addFirstElement(node);
    }

    public void addElementAtBegin(E element){
        Node<E> node = new Node<E>(element,null);
        if(size>0){
            node.setNext(head);
            head=node;
            size++;
        }else
            addFirstElement(node);
    }
    public E removeFirstElement(){
        Node<E> tmp = head;
        head= head.getNext();
        size--;
        return tmp.getElement();
    }
    public E removeElement(int i) throws WrongIndexException {
        if(i<0 && i>size-1)
            throw new WrongIndexException();
        else{
            Node<E> node = head;
            Node<E> next = head.getNext();
            if(i==0){
                head=head.getNext();
                return node.getElement();
            }
            for(int j=1;j<i;j++){
                node = next;
                next = next.getNext();
            }
            node.setNext(next.getNext());
            return next.getElement();
        }
    }

    public E removeElement(E element) throws NoSuchElementException{
        if(size>0){
            Node<E> tmp = head;
            Node<E> next =null;
            if(head.getElement().compareTo(element)==0){
                head = head.getNext();
                size--;
                return tmp.getElement();
            }
            while(tmp.getNext()!=null){
                next = tmp.getNext();
                if(next.getElement().compareTo(element)==0){
                    tmp.setNext(next.getNext());
                    size--;
                    break;
                }
            }
            return next.getElement();
        }else throw new NoSuchElementException();
    }

    public E first(){
        if(!isEmpty())
            return head.getElement();
        return null;
    }

    public E last(){
        if(!isEmpty())
            return tail.getElement();
        return null;
    }
}
