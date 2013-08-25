package string;

public enum BackSlashRemoverState {
    FIND {
        public BackSlashRemoverState send(BackSlashRemover remover) {
            char c = remover.currentChar;
            if (c == '\\') {
                remover.founded.append(c);
                return FOUNDED;
            }
            remover.result.append(c);
            return FIND;
        }
    }, FOUNDED {
        public BackSlashRemoverState send(BackSlashRemover remover) {
            char c = remover.currentChar;
            if (c == '\n') {
                remover.clean(remover.founded);
                return FIND;
            }
            if (c != '\\') {
                remover.founded.append(c);
                remover.result.append(remover.founded);
                remover.clean(remover.founded);
                return FIND;
            }
            remover.founded.append(c);
            return FOUNDED;
        }
    }, REMOVE, APPEND;

    public BackSlashRemoverState send(BackSlashRemover remover) {
        return this;
    }
}
