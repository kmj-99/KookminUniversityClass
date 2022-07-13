# HW3 - task를 지켜서 Binaray Tree구현

## task 리스트
1. BinNode interface를 구현  
2. BinNode를 상속하여 INode를 구현 (INode는 값, 왼쪽 자식 포인터, 오른쪽 자식 포인터를 가진다.)  
3. 구현한 BinNode와 INode를 이용하여 10자 이상의 영어 단어 혹은 구의 글자들로 tree를 구성  
4. preorder, inorder, postorder traversal을 수행하는 함수를 구현  
5. BinNode를 상속하여 LNode를 구현 (LNode는 양쪽 자식이 모두 없는 Leaf node만을 위한 구현)  
6. task 3에서 구현한 tree에서 leaf node를 기존 INode에서 LNode로 교체하고, task 5를 수행하여 기존 결과와 동일함을 확인  


## tas1 && task2

아래와 같이 BinNode interface를 정의한다. 
```.java
public interface BinNode<E>{
  public E element(); // node의 value
  public E setElement(E item);
  public BinNode<E> left(); 
  public BinNode<E> right();
  public boolean isLeaft(); // 해당 node가 LNode인지 아닌지 확인해서 boolean값을 반환
}
```
<br/>

BinNode interface를 상속하여서 INode를 구현한다.
```.java
public class INode<E> implements BinNode<E>{
  private E data;
  private BinNode<E> left;
  private BinNode<E> right;
  public INode(E data,BinNode<E> left ,BinNode<E> right) {
    this.data=data;
    this.left=left;
    this.right=right;
  }
  
  @Override
  public E element() {
    return data;
  }
  
  @Override
  public E setElement(E item) {
    this.data=item;
    return this.data;
  }
  
  @Override
    public BinNode<E> left() {
    return left;
  }
  
  @Override
  public BinNode<E> right() {
    // TODO Auto-generated method stub
    return right;
  }
  
  @Override
  public boolean isLeaft() {
    return left==null&&right==null;
 }
  
}
```
<br/><br/>

## task3
"DATASTRUCTURE"로 트리를 구성하였다. 그리고 inorder traversal을 수행하였을 때 DATASTRUCTURE로
올바르게 문장이 구성되도록 하였다. 중복되는 글자는 1,2,3...으로 구분(ex- A가 두번 나온다면 a1,a2로 서서 노드를 구분했다.)

![test_image](https://user-images.githubusercontent.com/76093968/178686501-34359b46-c432-4a6d-a3b8-b7cd18fafda9.png)

<br/>
위 트리를 실제 코드로 구성하고 inorder traversal를 수행하였을 때 올바르게 문장이 나오도록 구현하고 테스트를 했다..  

```.java
public class INodeTest {
  public static void main(String[] args) {
  
  //왼쪽 서브트리
  BinNode<String> d=new INode<>("D",null,null);
  BinNode<String> t1=new INode<>("T",null,null);
  BinNode<String> a2=new INode<>("A",d,t1);

  BinNode<String> s=new INode<>("S",null,null);
  BinNode<String> r2=new INode<>("R",null,null);
  BinNode<String> t2=new INode<>("T",s,r2);
  BinNode<String> a1=new INode<>("A",a2,t2);

  //오른쪽 서브트리
  BinNode<String> e=new INode<>("E",null,null);
  BinNode<String> u2=new INode<>("U",null,null);
  BinNode<String> r1=new INode<>("R",u2,e);

  BinNode<String> c=new INode<>("C",null,null);
  BinNode<String> t3=new INode<>("T",c,r1);

  //루트 노드
  BinNode<String> u1=new INode<>("U",a1,t3); // root node


  System.out.print("inorder: ");
  inorder(u1);
  System.out.println();
}

public static <E> void inorder(BinNode rt) {
  if(rt==null) return;
  inorder(rt.left());
  System.out.print(rt.element());
  inorder(rt.right());
  }
  
}


```


![res_image](https://user-images.githubusercontent.com/76093968/178688108-6f1ec82a-7a3f-422c-95fc-fcf71906d574.png)

<br/><br/>

## task4
preoder , inorder , postorder traversal을 수행하는 함수를 구현하였다. 
```.java
public static <E> void preorder(BinNode rt) {
  if(rt==null) return;
  
  System.out.print(rt.element());
  preorder(rt.left());
  preorder(rt.right());
}

public static <E> void inorder(BinNode rt) {
  if(rt==null) return;

  inorder(rt.left());
  System.out.print(rt.element());
  inorder(rt.right());
}

public static <E> void postorder(BinNode rt) {
  if(rt==null) return;
  
  postorder(rt.left());
  postorder(rt.right());
  System.out.print(rt.element());
  }
}

```
<br/>
위 함수들이 잘 작동하는지 test코드를 만들어서 테스트를 해보았다.

```.java
public class INodeTest {
  public static void main(String[] args) {
  
  //왼쪽 서브트리
  BinNode<String> d=new INode<>("D",null,null);
  BinNode<String> t1=new INode<>("T",null,null);
  BinNode<String> a2=new INode<>("A",d,t1);

  BinNode<String> s=new INode<>("S",null,null);
  BinNode<String> r2=new INode<>("R",null,null);
  BinNode<String> t2=new INode<>("T",s,r2);
  BinNode<String> a1=new INode<>("A",a2,t2);

//오른쪽 서브트리
  BinNode<String> e=new INode<>("E",null,null);
  BinNode<String> u2=new INode<>("U",null,null);
  BinNode<String> r1=new INode<>("R",u2,e);

  BinNode<String> c=new INode<>("C",null,null);
  BinNode<String> t3=new INode<>("T",c,r1);

  //루트 노드
  BinNode<String> u1=new INode<>("U",a1,t3); // root node

  System.out.print("preorder: ");
  preorder(u1);
  System.out.println();
  System.out.print("inorder: ");
  inorder(u1);
  System.out.println();
  System.out.print("postorder: ");
  postorder(u1);
}

```

![order_image](https://user-images.githubusercontent.com/76093968/178691355-f3b881ce-44a5-4116-be64-560768e437f8.png)

<br/><br/>

## task5

BinNode를 상속받아서 서브트리가 없는 LNode를 구현하였다.

```.java
public class LNode<E> implements BinNode<E> {
  
    public E data;
  
  public LNode(E data) {
     this.data=data;
  }

  @Override
  public E element() {
      return data;
  } 

  @Override
  public E setElement(E item) {
    this.data=item;
    return this.data;
  
  }

  @Override
  public BinNode<E> left() {
    return null;
  }

  @Override
  public BinNode<E> right() {
    return null;
  }

  @Override
  public boolean isLeaft() {
    return false;
  }

}

```

<br/><br/>

## task6
task3에서 구현하였던 tree에서 INode를 LNode로 바꾸는 작업을 하고 테스트를 해보았을 때 INode를 쓸때와 똑같은 결과가 나왔다.

```.java

public class INodeTest {
  public static void main(String[] args) {


    //왼쪽 서브트리
    LNode<String> d=new LNode<>("D");
    LNode<String> t1=new LNode<>("T");
    BinNode<String> a2=new INode<>("A",d,t1);

    LNode<String> s=new LNode<>("S");
    LNode<String> r2=new LNode<>("R");
    BinNode<String> t2=new INode<>("T",s,r2);
    BinNode<String> a1=new INode<>("A",a2,t2);


    //오른쪽 서브트리
    LNode<String> e=new LNode<>("E");
    LNode<String> u2=new LNode<>("U");
    BinNode<String> r1=new INode<>("R",u2,e);
    LNode<String> c=new LNode<>("C");
    BinNode<String> t3=new INode<>("T",c,r1);


    //루트 노드
    BinNode<String> u1=new INode<>("U",a1,t3); // root node
    System.out.print("preorder: ");
    preorder(u1);

    System.out.println();
    System.out.print("inorder: ");
    inorder(u1);
    
    System.out.println();
    System.out.print("postorder: ");
    postorder(u1);
}


```
![res_image](https://user-images.githubusercontent.com/76093968/178694366-e743c590-5d24-4008-b81f-b2c239a0c8f5.png)


