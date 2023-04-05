package hexlet.code;

public class StringSchema {
    private boolean requiredCheck;
    private boolean requiredContainsCheck;
    private Object content;
    //private int minLength;
    private Object containsContent;
    private Boolean isValid;


    StringSchema() {
        this.requiredCheck = false;
        this.requiredContainsCheck = false;
        this.content = null;
        //this.minLength = 0;
        this.containsContent = null;
        this.isValid = true;

    }

    //@Override
    public Boolean isValid(Object c) {
        this.content = c;
        if (!this.requiredCheck) {
            return this.isValid;
        }
        if (this.requiredCheck
                && this.content instanceof String
                && this.content != null
                && toStr(this.content).length() > 0) {
            this.isValid = true;
        } else {
            this.isValid = false;
        }

        if (this.requiredContainsCheck) {
            if (this.requiredCheck
                    && this.content instanceof String
                    && this.content != null
                    && ((String) this.content).length() > 0
                    && ((String) this.containsContent).length() > 0
                    && toStr(this.content).contains(toStr(this.containsContent))) {
                this.isValid = true;
            } else {
                this.isValid = false;
            }

        }
        return this.isValid;
    }

    public void required() {
        this.requiredCheck = true;
    }

    public StringSchema contains(Object c) {
        this.requiredContainsCheck = true;
        this.containsContent = c;
        return this;
    }

    private String toStr(Object o) {
        return o.toString();
    }

}
