package string;

import static string.BackSlashRemoverState.*;
public class BackSlashRemover {

    BackSlashRemoverState state = FIND;
    StringBuilder result = new StringBuilder();
    StringBuilder founded = new StringBuilder();

    public BackSlashRemoverState getState() {
        return state;
    }

    public void send(char c) {
        send(c,this.state);
    }
    public void send(BackSlashRemoverState state) {
        this.state = state;
    }

    void send(char c,BackSlashRemoverState state) {
        this.state = state;
        switch (state) {
            case FIND: find(c);break;
            case FINDED: founded(c);break;
            case REMOVE: remove();break;
            case APPEND: append(c);break;
        }
    }

    void find(char c) {
        if (c=='\\') {
            send(c,FINDED);
        } else {
            result.append(c);
        }
    }
    void founded(char c) {
       if (c=='\\') {
           founded.append(c);
       } else if (c=='\n') {
           send(c,REMOVE);
       } else {
           send(c,APPEND);
       }
    }
    void remove(){
        founded = new StringBuilder();
        send(FIND);
    }

    void append(char c) {
        result.append(founded);
        founded = new StringBuilder();
        send(c,FIND);
    }
    public String getResult() {
            return result.toString()+founded.toString();
    }
}
