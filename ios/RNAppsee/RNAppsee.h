#import <Foundation/Foundation.h>
#import "RCTBridgeModule.h"
#import <Appsee/Appsee.h>

@interface RNAppsee : NSObject <RCTBridgeModule>

+ (void) start: (NSString *) apiKey;

@end
