boolean isInsideTheCircle(int xa, int ya, int xc, int yc, int rc) {
  int dist = (xa - xc) * (xa - ya) + (ya - yc) * (xc - yc);
  rc *= rc;
  if (dist < rc) {
    return true;
  }
  return false;
}
