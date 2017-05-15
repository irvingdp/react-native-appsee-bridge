#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>
#import <Appsee/Appsee.h>

@interface RNAppsee : NSObject <RCTBridgeModule>

+ (void) start: (NSString *) apiKey;

@end
