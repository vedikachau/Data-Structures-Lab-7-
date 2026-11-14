import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void addSix() {
        assertEquals(45, Main.addSix(39));
    }


    @Test
    void countNodes(){
        assertEquals(4, binaryTree.countNodes(new binaryTree.bTree(2, new binaryTree.bTree(3, null, null), new binaryTree.bTree(1,
                new binaryTree.bTree(1, null, null), null))));
    }

    @Test
    void mirror(){
        assertEquals(new binaryTree.bTree(4, new binaryTree.bTree(6, new binaryTree.bTree(7, null, null),
                        new binaryTree.bTree(5, null, null)),
                        new binaryTree.bTree(2, new binaryTree.bTree(3, null, null),
                                new binaryTree.bTree(1, null, null))),
                binaryTree.mirror(new binaryTree.bTree(4, new binaryTree.bTree(2, new binaryTree.bTree(1, null, null),
                        new binaryTree.bTree(3, null, null)),
                        new binaryTree.bTree(6, new binaryTree.bTree(5, null, null),
                                new binaryTree.bTree(7, null, null)))));
    }

    @Test
    void preorder(){
        assertEquals(new binaryTree.List(4, new binaryTree.List(2, new binaryTree.List(1,
                        new binaryTree.List(3, new binaryTree.List(6, new binaryTree.List(5, new binaryTree.List(7, null))))))),
                binaryTree.preorder(new binaryTree.bTree(4, new binaryTree.bTree(2, new binaryTree.bTree(1, null, null),
                        new binaryTree.bTree(3, null, null)),
                        new binaryTree.bTree(6, new binaryTree.bTree(5, null, null),
                                new binaryTree.bTree(7, null, null)))));
    }

    @Test
    void findPath(){
        assertEquals(new binaryTree.List("left", new binaryTree.List("right", new binaryTree.List("here",
                        null))),
                binaryTree.findPath((new binaryTree.bTree(4, new binaryTree.bTree(2, new binaryTree.bTree(1, null, null),
                        new binaryTree.bTree(3, null, null)),
                        new binaryTree.bTree(6, new binaryTree.bTree(5, null, null),
                                new binaryTree.bTree(7, null, null)))), 3));
    }

    //when not in tree
    @Test
    void findPath2(){
        IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, ()-> binaryTree.findPath((new binaryTree.bTree(4, new binaryTree.bTree(2,
                new binaryTree.bTree(1, null, null), new binaryTree.bTree(3, null, null)),
                new binaryTree.bTree(6, new binaryTree.bTree(5, null, null),
                        new binaryTree.bTree(7, null, null)))), 10));
    }

}
