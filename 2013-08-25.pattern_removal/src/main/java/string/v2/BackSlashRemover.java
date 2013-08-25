package string.v2;

public class BackSlashRemover {

    State state = State.FIND;
    StringBuilder result = new StringBuilder();
    StringBuilder founded = new StringBuilder();
    char currentChar;

    public enum State {
        FIND {
            public State send(BackSlashRemover remover) {
                char c = remover.currentChar;
                if (c == '\\') {
                    remover.founded.append(c);
                    return FOUNDED;
                }
                remover.result.append(c);
                return FIND;
            }
        },
        FOUNDED {
            public State send(BackSlashRemover remover) {
                char c = remover.currentChar;
                if (c == '\n') {
                    remover.founded.setLength(0);
                    return FIND;
                }
                if (c != '\\') {
                    remover.founded.append(c);
                    remover.result.append(remover.founded);
                    remover.founded.setLength(0);
                    return FIND;
                }
                remover.founded.append(c);
                return FOUNDED;
            }
        };

        abstract public State send(BackSlashRemover remover);
    }

    public String process(String string){
        for(char c: string.toCharArray()){
            send(c);
        }
        String result= getResult();
        this.result= new StringBuilder();
        this.founded = new StringBuilder();
        return  result;
    }

    public void send(char c){
        currentChar = c;
        state = state.send(this);
    }

    public String getResult() {
        return result.toString()+founded.toString();
    }

}
