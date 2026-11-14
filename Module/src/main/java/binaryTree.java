//import static javax.management.remote.JMXConnectorFactory.connect;

public class binaryTree {
    //BT
    record bTree<T>(T val, bTree<T> left, bTree<T> right){};

    //need equals method?
    /*<T>boolean equals(bTree<T> other){
        if(other instanceof bTree<T>){
            switch(other){
                case null: return this == null;
                case bTree(T v, bTree <T>l, bTree<T> r):
                    return this.val==v && check(this.left, l) && check(this.right, r);
            }
        }
        return false;
    }

    //fix this
    public static <T>boolean check(bTree<T> one, bTree<T> two){
        switch(one){
            case null: return two == null;
            case bTree<T>(T val, bTree l, bTree r):
                if(two.val == null) {
                    return false;
                }
                else if(val == two.val){
                    return check(l, two.left) && check(r, two.right);
                }
                return false;
        }
    }*/

    public static <T>int countNodes(bTree<T> l){
        switch(l){
            case null: return 0;
            case bTree<T>(T v, bTree<T> le, bTree<T> r):
                return 1 + countNodes(le) + countNodes(r);
        }
    }

    //this seems too easy?
    public static <T>bTree mirror(bTree<T> t){
        switch(t){
            case null: return null;
            case bTree<T>(T val, bTree<T> l, bTree<T> r):
                return new bTree<T>(val, mirror(r), mirror(l));
                //but what does it do when it reahes a leaf?
        }
    }

    /*public static <T>List addLeft(bTree<T> t){
        switch(t){
            case null: return new List(null, null);
            case bTree<T>(T val, bTree le, bTree r):
                while(le!=null){
                    return new List(val, addLeft(le));
                }
            }
    }

    public static <T>List addRight(bTree<T> t){
        switch(t){
            case null: return new List(null, null);
            case bTree<T>(T val, bTree le, bTree r):
                while(r!=null){
                    return new List(val, addRight(r));
                }
            }
    }*/

    public static <T>List connect(List<T> list1, List<T> list2){
        switch(list1){
            case null: return list2;
            case List<T>(T f, List<T> r):
                return new List<T>(f, connect(r,list2));
        }
    }

    public static <T>List preorder(bTree<T> t){
        switch(t){
            case null: return null;
            case bTree<T>(T val, bTree<T> le, bTree<T> r):
                List linkedl = new List(val, preorder(le));
                List linkedr = preorder(r);
                return connect(linkedl, linkedr);
        }
    }

    //but how can it return the string if we need the boolean check for the function to work?
    public static <T>List<String> checkTree(bTree<T> t, T val){
        //just here
        if(t==null){
            return null;
        }
        if(t.val.equals(val)){
            return new List<String>("here", null);
        }
        List<String> leftCheck = checkTree(t.left, val);
        List<String> rightCheck = checkTree(t.right, val);
        if(leftCheck!=null){
            return new List<String>("left", leftCheck);
        }
        else if(rightCheck!=null){
            return new List<String>("right", rightCheck);
        }
        else{
            return null;
        }
    }

    public static <T>List<String> findPath(bTree<T> l, T v){
        //how to compare them using equals
        //compare them suing equals
        List<String> check = checkTree(l, v);
        if(check==null){
            throw new IndexOutOfBoundsException("vale not found");
        }
        else{
            return check;
        }
    }


    //generic linkedlist
    record List<T>(T first, List<T> rest) { }



}