해당 과제는 ArrayList와 LinkedList를 구현하는 과제이다.


## 개발환경
**OS** : 윈도우  

**IDE** : 이클립스(JDK 1.17)  

**언어** : 자바  



## ArrayList 구현

밑에 List라는 인터페이스를 상속받아서 ArrayList를 구현한다.

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

Array List 구현코드

```.java
public class ArrayList<E> implements List<E> {
	
	private static final int defaultSize=10; 
	private int listSize;
	private E[] data;
	
	
	public ArrayList() {
		this(defaultSize);
	}
	
	public ArrayList(int size) {
		listSize=0;
		data=(E[]) new Object[size];
	}
	
	

	@Override
	public void clear() {
		listSize=0;
	}

	@Override
	public void insert(int pos, E item) {
		for(int i=listSize;i>pos;i--) {
			data[i]=data[i-1];
		}
		data[pos]=item;
		listSize++;
	}

	@Override
	public void append(E item) {
		data[listSize++]=item;
	}

	@Override
	public void update(int pos, E item) {
		data[pos]=item;
	}

	@Override
	public E getValue(int pos) {
		return data[pos];
	}

	@Override
	public E remove(int pos) {
		E ret=data[pos];
		
		for(int i=pos;i<listSize-1;i++) {
			data[i]=data[i+1];
			
		}
		
		listSize--;
		return ret;
	}

	@Override
	public int length() {
		return listSize;
	}



}

```
<br/><br/>

구현한 ArrayList를 ArrayListTest클래스를 만들어서 테스트를 해보았다.

```.java
public class ArrayListTest {
	public static void main(String[] args) {
		
		ArrayList<Integer> mylist=new ArrayList<>();
		
		mylist.append(1);
		mylist.append(2);
		mylist.append(3);
		mylist.append(4);
		mylist.update(2,10 );
		int size=mylist.length();
		for(int i=0; i<size;i++) {
			System.out.println(mylist.getValue(i));
		}
		mylist.clear();
		System.out.println(mylist.length());

	}
}
```
<br/><br/>
출력 결과
![reulst_2](https://user-images.githubusercontent.com/76093968/178142546-2df7d486-fe53-4f16-a16b-6e98e56eb93b.png)


<br/><br/><br/>

## LinkedList구현

마찬가지로 위에 있는 인터페이스인 List를 상속받아서 LinkedList를 구현다.

```.java
public class LinkedList<E> implements List<E> {
	
	
	Link<E> head,tail;
	int size;
	
	
	public LinkedList() {
		head=tail=new Link<E>(null,null);
		size=0;
	}
	
	
	@Override
	public void clear() {
		head.next=null;
		tail=head;
		size=0;
	}

	@Override
	public void insert(int pos, E item) {
		Link<E> curr=head;
		for(int i=0;i<pos;i++) {
			curr=curr.next;
		}
		curr.next=new Link<E>(item,curr.next);
		
		if(curr==tail) {
			tail=curr.next;
			
		}
		
		size++;
		
	}

	@Override
	public void append(E item) {
		Link<E> n =new Link(item,null);
		tail.next=n;
		tail=n;
		size++;
	}

	@Override
	public void update(int pos, E item) {
		Link<E> curr=head;
		for(int i=0;i<pos;i++) {
			
			curr=curr.next;
		}

		curr.next.item=item;
	}

	@Override
	public E getValue(int pos) {
		Link<E> curr=head;
		for(int i=0;i<pos;i++) {
			
			curr=curr.next;
		}
		
		return curr.next.item;
	}

	@Override
	public E remove(int pos) {
		
		Link<E> curr=head;
		for(int i=0;i<pos;i++) {
			
			curr=curr.next;
		}
		
		E ret=curr.next.item;
		
		if(curr.next==tail) {
			tail=curr;
			
		}
		curr.next=curr.next.next;
		size--;
		return ret;
	}

	public String toString() {
		String a="";
		Link<E> curr=head;
		for(int i=0;i<size;i++) {
			if(i==size-1) {
				a+=curr.next.item;
			}else {
			a+=curr.next.item+",";
			curr=curr.next;
			}
		}
		
		return a;
		
	}	
	@Override 
	public int length() {
		return size;
	}
	
}


```
<br/><br/>
구현한 LinkedList를 LinkedListTest클래스를 만들어서 테스트를 해보았다.

```.java
public class LinkedListTest {
	public static void main(String[] args) {
		
		List<Integer> myList=new LinkedList<>();
		
		myList.append(3);
		myList.append(10);
		myList.append(11);
		myList.append(12);
		myList.insert(1,21);
		myList.update(0, 30);
		System.out.println(myList);
		
	}

}

```
<br/><br/>
출력 결과

![result_1](https://user-images.githubusercontent.com/76093968/178142685-08d3efa4-0cb3-486c-a469-14dc18cf9dcd.png)





