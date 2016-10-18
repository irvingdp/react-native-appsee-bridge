#import "RNAppsee.h"

@implementation RNAppsee

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(startScreen:(NSString *)screenName){
    [Appsee startScreen:screenName];
};

RCT_EXPORT_METHOD(addEvent:(NSString *)eventName){
    [Appsee addEvent:eventName];
}

@end
