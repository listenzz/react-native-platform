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


@end