"use strict";
// remember with abstract classes
// you cannot create objects from them
// you can only create objects that extend them
class TakePhoto {
    constructor(cameraMode, filter) {
        this.cameraMode = cameraMode;
        this.filter = filter;
    }
    // this method is already defined and not abstract
    // so no need to do anything with it in the inheriting class
    getReelTime() {
        // some complex calculation
        return 8;
    }
}
class Instagram extends TakePhoto {
    constructor(cameraMode, filter, burst) {
        super(cameraMode, filter);
        this.cameraMode = cameraMode;
        this.filter = filter;
        this.burst = burst;
    }
    getSepia() {
        console.log("SEPIA");
    }
}
const pj = new Instagram("test", "sepia", 3);
pj.getReelTime();
