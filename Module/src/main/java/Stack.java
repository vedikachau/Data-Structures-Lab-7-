public class Stack {
    //BT
    record bTree<T>(T val, bTree left, bTree right){};

    //need equals method?
    boolean equals(bTree other){
        if(other instanceof bTree){
            switch(other){
                case null: return this == null;
                case bTree(T val, bTree l, bTree r):
                    return this.val==val && check(this.left, l) && check(this.right, r);
            }
        }
        return false;
    }

    //fix this
    boolean check(bTree one, bTree two){
        switch(one){
            case null: return two == null;
            case bTree(T val, bTree l, bTree r):
                if(two.val == null) {
                    return false;
                }
                else if(val == two.val){
                    return check(l, two.left) && check(r, two.right) ;
                }
                return false;
        }
    }

    public static int countNodes(bTree l){
        switch(l){
            case null: return 0;
            case bTree(T val, bTree l, bTree r):
                return 1 + countNodes(l) + countNodes(r);
        }
    }

    //this seems too easy?
    public static bTree mirror(bTree l){
        switch(l){
            case null: return new bTree(null, null, null);
            case bTree(T val, bTree l, bTree r):
                return new bTree(val, r, l);
        }
    }

    public static <T>List preorder(bTree l){
        switch(l){
            case null: return new <T>List(null, null);
            case bTree(T val, bTree l, bTree r):
                List linkedl;
                //add vals to linked1
                linkedl.add(val);
                linkedl.add(l);
                linkedl.add(r);
                return linkedl;
        }
    }

    public static <String>List findPath(bTree l, T val){
        //use preorder method, then see if the val is in the linked list?

    }







    //generic linkedlist
    record List(T first, List rest) { }



}