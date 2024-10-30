// remember with abstract classes
// you cannot create objects from them
// you can only create objects that extend them

abstract class TakePhoto {
  constructor(public cameraMode: string, public filter: string) {}

  // abstract methods do not have to defined in the abstract class
  // but they do need to be implemented in a class that
  // extends the abstract class
  abstract getSepia(): void;

  // this method is already defined and not abstract
  // so no need to do anything with it in the inheriting class
  getReelTime(): number {
    // some complex calculation
    return 8;
  }
}

class Instagram extends TakePhoto {
  constructor(
    public cameraMode: string,
    public filter: string,
    public burst: number
  ) {
    super(cameraMode, filter);
  }

  getSepia(): void {
    console.log("SEPIA");
  }
}

const pj = new Instagram("test", "sepia", 3);

pj.getReelTime();
