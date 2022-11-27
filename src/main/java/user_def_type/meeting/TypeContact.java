package user_def_type.meeting;

enum TypeContact {
    SKYPE("sds"), VIBER("ghhghg"), TELEGRAM("hghgh"), TELEPHONE("nvbn"), EMAIL("jghgh");
    String regexp;

    TypeContact(String regexp) {
        this.regexp = regexp;
    }
    boolean validate(String valueContact){
        return valueContact.matches(regexp);
    }
}