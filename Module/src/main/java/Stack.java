public class Stack<T> {
    //BT
    record bTree(T left, T right, bTree tree);

    //need equals method?
    boolean equals(bTree other){
        if(other instanceof bTree){
            switch(other){
                case null: return this == null;
                case bTree(T l, T r, T t):
                    return this.left==l && this.right==r && check(this.tree, t);
            }
        }
    }

    boolean check(bTree one, bTree two){
        switch(one){
            case null: return two== null;
            case bTree(T l, T r, bTree r):
                if(two == null) {
                    return false;
                }
                else if(l==two.left && r==two.right){
                    return check(r, two.tree);
                }
                return false;
        }
    }

    public static int countNodes(bTree l){
        switch(l){
            case null: return 0;
            case bTree(T l, T r, bTree t):
                return 2 + countNodes(t);
        }
    }

    //this seems too easy?
    public static bTree mirror(bTree l){
        switch(l){
            case null: return new bTree(null, null, null);
            case bTree(T l, T r, bTree t):
                return new bTree(r, l, t);
        }
    }

    public static <T>List preorder(bTree l){
        switch(l){
            case null: return new <T>List(null, null);
            case bTree(T l, T r, T t):
                //insert into the list,
                //do retirn new List(insert(l,r), t)???
        }
    }

    public static <String>List findPath(bTree l, T val){
        //use preorder method, then see if the val is in the linked list?

    }





    

    //generic linkedlist
    record List(T first, List rest) { }
    List elts;

    Stack(List elts) {
        this.elts = elts;
    }



}