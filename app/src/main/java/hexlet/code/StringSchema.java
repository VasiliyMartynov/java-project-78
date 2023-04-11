package hexlet.code;

public class StringSchema {
    private boolean isRequiredToBeChecked;
    private boolean isRequiredToBeCheckedForMinLength;
    private boolean isRequiredToBeCheckedForContaining;


    private Object content;
    private int minLength;
    private Object containsContent;
    private Boolean isValid;


    StringSchema() {
        this.isRequiredToBeChecked = false;
        this.isRequiredToBeCheckedForContaining = false;
        this.isRequiredToBeCheckedForMinLength = false;

        this.content = null;
        this.minLength = 0;
        this.containsContent = null;

        this.isValid = true;

    }

    //@Override
    public Boolean isValid(Object c) {
        this.content = c;

        if (!this.isRequiredToBeChecked) {
            return this.isValid;
        } else {
            this.isValid = basicCheck();
        }

        if (this.isRequiredToBeCheckedForContaining) {
            this.isValid = containCheck();
        }

        if (this.isRequiredToBeCheckedForMinLength) {
            this.isValid = minLengthCheck();
        }

        return this.isValid;
    }

    public void required() {
        this.isRequiredToBeChecked = true;
    }

    public StringSchema contains(Object c) {
        this.isRequiredToBeCheckedForContaining = true;
        this.containsContent = c;
        return this;
    }

    public StringSchema minLength(int n) {
        this.isRequiredToBeCheckedForMinLength = true;
        this.minLength = n;
        return this;
    }

    private String toStr(Object o) {
        return o.toString();
    }

    private boolean basicCheck() {
        if (this.content instanceof String && this.content != null && toStr(this.content).length() > 0) {
            return true;
        }
        return false;
    }

    private boolean containCheck() {
        if (((String) this.containsContent).length() > 0 && toStr(this.content).contains(toStr(this.containsContent))) {
            return true;
        }
        return false;
    }

    private boolean minLengthCheck() {
        if (this.content.toString().length() >= this.minLength) {
            return true;
        }
        return false;
    }


}
