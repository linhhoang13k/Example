boolean willYou(boolean young, boolean beautiful, boolean loved) {
    return ((young == false || beautiful == false) && loved) || (loved == false && young && beautiful);
}
