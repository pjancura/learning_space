import { PropsWithChildren, ReactNode } from "react";
import { Image, ImageBackground, StyleSheet } from "react-native";

type Props = PropsWithChildren<{
  children: ReactNode;
  height: number;
}>;

const windowDimensions = Dimensions.get("window");
const screenDimensions = Dimensions.get("screen");

const CommunityCircleBackground = ({ height, children }: Props) => {
  const image = require("../assets/images/communityCircleWithBorder.png");

  return (
    // <Image source={image} style={[styles.bgImage, {top: ( height * 0.5) - (350 * 0.5) }]}/>
    <ImageBackground
      source={image}
      style={styles.bgContainer}
      imageStyle={styles.bgImage}
    >
      {children}
    </ImageBackground>
  );
};

const styles = StyleSheet.create({
  bgContainer: {
    height: "100%",
    width: "100%",
    display: "flex",
  },
  bgImage: {
    resizeMode: "contain",
  },
});

export default CommunityCircleBackground;
