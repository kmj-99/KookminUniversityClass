# HW - Stack,Queue,Doubly Linked List구현 

## 1) ListIterator를 포함하여 Doubly Linked List를 구현 (DList.java)

List인터페이스를 정의

```.java

public interface List<E> {
	public void clear();
	public void insert(int pos , E item);
	public void appendLast(E item);
	public void appendFirst(E item);
	public void update(int pos , E item);
	public E getValue(int pos);
	public E remove(int pos);
	public int length();
	public ListIterator<E> listIterator();
}
```

<br/><br/>

List를 상속받아서 DLinkList를 구현.
```.java
public class DLinkList<E> implements List<E>{
	
	DLink<E> head,tail;
	int size;
	
	public DLinkList() {
		head=new DLink(null,null,null);
		tail=new DLink(null,null,null);
		size=0;
	}

	@Override
	public void clear() {
		head.setNext(null);
		tail.setPrev(null);
		size=0;
		
	}

	@Override
	public void insert(int pos, E item) {
		DLink<E> curr=head;
		for(int i=0;i<pos;i++) {
			curr=curr.next();
		}
		curr.setNext(new DLink(item,curr,curr.next()));
		curr.next().next().setPrev(curr.next());
		
		size++;
	}
	
	@Override
	public void appendFirst(E item) {
		DLink<E> newLink=new DLink(item ,null,null);
		newLink.setNext(head.next());
		
		if(head.next()!=null) {
			head.next().setPrev(newLink);
			head.setNext(newLink);
		}else {
			head.setNext(newLink);
			tail.setPrev(newLink);
		}
		
		size++;
		
	}
	
	@Override
	public void appendLast(E item) {
		DLink<E> newLink=new DLink(item ,null,null);
		
		if(tail.prev()!=null) {
			tail.prev().setNext(newLink);
			newLink.setPrev(tail.prev());
			tail.setPrev(newLink);
		}else {
			tail.setPrev(newLink);
			head.setNext(newLink);
		}
		
		size++;
		
	}

	@Override
	public void update(int pos, E item) {
		DLink<E> curr=head;
		for(int i=0;i<pos;i++) {
			curr=curr.next();
		}
		curr.next().setItem(item);
		
	}

	@Override
	public E getValue(int pos) {
		DLink<E> curr=head;
		for(int i=0;i<pos;i++) {
			curr=curr.next();
		}
		return curr.next().item();
	}

	@Override
	public E remove(int pos) {
		DLink<E> curr=head;
		for(int i=0;i<pos;i++) {
			curr=curr.next();
		}
		E ret=curr.next().item();
		curr.next().next().setPrev(curr);
		curr.setNext(curr.next().next());
		size--;
		return ret;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListIterator<E>() {
			DLink<E> curr=head;
			@Override
			public boolean hasNext() {
				return curr!=tail.prev();
			}

			@Override
			public E next() {
				curr=curr.next();
				return curr.item();
			}

			@Override
			public boolean hasPrevious() {
				return curr!=head.next();
			}

			@Override
			public E previous() {
				curr=curr.prev();
				return curr.item();
			}
			
			
		};
	}
	
	
}

```


<br/><br/>
## 2) Array를 사용하여 Stack을 구현 (ArrayStack.java)

Stack인터페이스 정의

```.java
public interface Stack<E> {
	
	public void clear();
	public void push(E it);
	public E pop();
	public E topValue();
	public int length();

}

```
<br/><br/>

인터페이스 Stack을 상속받아서 ArrayStack을 구현

```.java
public class ArrayStack<E> implements Stack<E>{
	private int maxSize;
	private int top;
	private int size;
	private E [] listArray;
	
	public ArrayStack() {
		this(10);
	}
	public ArrayStack(int maxSize) {
		this.maxSize=maxSize;
		top=-1;
		size=0;
		listArray=(E[])new Object[maxSize];
	}

	@Override
	public void clear() {
		top=-1;
	}

	@Override
	public void push(E it) {
		if(top==maxSize-1) {
			System.out.println("size of stack is max");
		}else {
			size++;
			listArray[++top]=it;
		}
		
	}
	
	@Override
	public E pop() {
		E res=listArray[top];
		top--;
		size--;
		return res;
	}

	@Override
	public E topValue() {
		return listArray[top];
	}

	@Override
	public int length() {
		return size;
	}


}

```

<br/><br/>
## 3) Link를 사용하여 Queue를 구현 (LinkedQueue.java)

Queue인터페이스 
```.java
public interface Queue<E> {
	public void clear();
	public E dequeue();
	public void enqueue(E it);
	public E frontValue();
	public E rear();
	public int length();

}
```
<br/><br/>
인터페이스 Queue를 상속받아서 LinkedQueue를 구현

```.java
public class LinkedQueue<E> implements Queue<E> {
	private int maxSize;
	QLink<E> rear;
	QLink<E> front;
	int size;
	
	public LinkedQueue() {
		this(10);
	}
	
	public LinkedQueue(int maxSize) {
		this.maxSize=maxSize;
		rear=new QLink(null,null);
		front=new QLink(null,null);
		size=0;
	}

	@Override
	public void clear() {
		rear.setNext(null);
		front.setNext(null);
		size=0;
	}

	@Override
	public E dequeue() {
		E res=front.getNext().getItem();
		front.setNext(front.getNext().getNext());
		size--;
		return res;
	}

	@Override
	public void enqueue(E it) {
		if(size==maxSize) {
			System.out.println("Queue is max.");
		}else {
			QLink<E> newLink=new QLink(it,null);
			if(rear.getNext()==null) {
				rear.setNext(newLink);
				front.setNext(newLink);
			}else {
				rear.getNext().setNext(newLink);
				rear.setNext(newLink);
			}
			size++;
		}
		
	}

	@Override
	public E frontValue() {
		E res=front.getNext().getItem();
		return res;
	}

	@Override
	public E rear() {
		E res=rear.getNext().getItem();
		return res;
	}

	@Override
	public int length() {
		return size;
	}

}

```



