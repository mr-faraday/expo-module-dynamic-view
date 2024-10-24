import { CustomDynamicView } from "@/modules/custom-dynamic-view";
import * as SplashScreen from "expo-splash-screen";
import { useRef } from "react";
import { Button, View } from "react-native";
import "react-native-reanimated";
import { SafeAreaProvider, SafeAreaView } from "react-native-safe-area-context";

// Prevent the splash screen from auto-hiding before asset loading is complete.
SplashScreen.preventAutoHideAsync();

export default function RootLayout() {
    const ref = useRef();

    const handlePress = () => {
        ref.current?.addView?.();
    };

    return (
        <SafeAreaProvider>
            <View style={{ backgroundColor: "yellow", flex: 1 }}>
                <SafeAreaView style={{ flex: 1 }}>
                    <View style={{ padding: 20 }}>
                        <Button title="Add View" onPress={handlePress} />
                    </View>

                    <CustomDynamicView ref={ref} style={{ flex: 1 }} />
                </SafeAreaView>
            </View>
        </SafeAreaProvider>
    );
}
