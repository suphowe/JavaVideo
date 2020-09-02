import React from 'react';
import {
    SafeAreaView,
    StyleSheet,
    Text,
    StatusBar,
    Button,
    NativeModules,
} from 'react-native';

const App = () => {
    return (
        <>
            <StatusBar barStyle="dark-content"/>
            <SafeAreaView>
                <Button title={'直播APP'} onPress={() => {
                    NativeModules
                        .ReactJavaModule
                        .startActivityFromJS("com.video_template.video.VideoActivity", null);
                }}/>
            </SafeAreaView>
        </>
    );
};

const styles = StyleSheet.create({});

export default App;
