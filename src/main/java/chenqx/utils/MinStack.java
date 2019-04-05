package chenqx.utils;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack<E> extends Stack<E> {

    private AuxiliaryStack<Integer> auxiliaryStack = new AuxiliaryStack<>();

    public E push(E object){
        checkMinIndex(object);
        return super.push(object);
    }

    public E pop(){
        int size = super.size();
        if (size==0){
            throw new EmptyStackException();
        }
        removeMinIndex();
        return super.pop();
    }

    private void removeMinIndex() {
        Integer peek = auxiliaryStack.peek();
        if (super.get(peek)==super.peek()){
            auxiliaryStack.pop();
        }
    }

    public E getMin() throws EmptyStackException{
        return super.get(auxiliaryStack.peek());
    }

    private void checkMinIndex(E object){
        if (object instanceof Integer){
            try {
                if ((Integer)object<(Integer) getMin()){
                    auxiliaryStack.push(super.size());
                }
            }catch (EmptyStackException e){
                auxiliaryStack.push(super.size());
            }
        }
    }

    class AuxiliaryStack<E> extends Stack<E>{

        public E pop() throws EmptyStackException{
            int size = super.size();
            if (size==0){
                throw new EmptyStackException();
            }
            return super.pop();
        }
    }
}
