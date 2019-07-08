public class Test1 {
  public static void main(String[] args) {
    try (MyResource resource1 = new MyResource();
        OtherResource resource2 = new OtherResource()) {
      resource1.do1();
      resource2.do2();
    } catch (Exception e) {
      e.printStackTrace();
      for (Throwable throwable : e.getSuppressed()) {
        System.out.println(throwable);
      }
    }

  }
}

class MyResource implements AutoCloseable {

  @Override
  public void close() throws Exception {
    System.out.println("close method executed");
    throw new UnsupportedOperationException("A problem has occurred");
  }

  public void do1() {
    System.out.println("method executed");
  }
}

class OtherResource implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("A");
    throw new UnsupportedOperationException("A problem has occurred");
  }

  public void do2() {
    System.out.println("executed");
  }
}

