boolean willYou(boolean young, boolean beautiful, boolean loved) {
    if (young && beautiful && loved)
        return false;
    if ((!young || !beautiful) && loved)
        return true;
    if ((!young || !beautiful) && !loved)
        return false;
    if (!young && !beautiful && !loved)
        return false;
    if ((young || beautiful) && !loved)
        return true;
    return false;
}
