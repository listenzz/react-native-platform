#import "RNPlatform.h"
#import <CoreLocation/CoreLocation.h>

@implementation RNPlatform

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup {
    return YES;
}

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(isGpsOpened:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject){
    resolve([NSNumber numberWithBool:[CLLocationManager locationServicesEnabled]]);
}

RCT_EXPORT_METHOD(openGpsSettings) {
    if (@available(iOS 10.0, *)) {
        [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"App-Prefs:root"] options:[NSDictionary new] completionHandler:nil];
    } else {
        // Fallback on earlier versions
        [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"prefs:root"]];
    }
}

RCT_EXPORT_METHOD(openSettings) {
    UIApplication *sharedApplication = [UIApplication sharedApplication];
    NSURL *url = [NSURL URLWithString:UIApplicationOpenSettingsURLString];
    if (@available(iOS 10.0, *)) {
      [sharedApplication openURL:url options:@{} completionHandler:^(BOOL success) {
        
      }];
    } else {
      [sharedApplication openURL:url];
    }
}

RCT_EXPORT_METHOD(isSimulator:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject) {
    BOOL isSimulator = NO;
#if TARGET_IPHONE_SIMULATOR
    isSimulator = YES;
#endif
    resolve(@(isSimulator));
}


@end
