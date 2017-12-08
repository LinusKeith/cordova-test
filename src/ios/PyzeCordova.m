//
//  PyzeCordova.m
//  Unity-iPhone
//
//  Created by Jesudas Joseph Lobo on 29/04/16.
//
//

#import "PyzeCordova.h"
#import <Cordova/CDVPlugin.h>

@implementation PyzeCordova

/***
 Region Util Methods
 ***/
+(NSDictionary*) getDictionaryFromString:(NSString *) customAttributes
{
    NSError *jsonError;
    NSData *objectData = [customAttributes dataUsingEncoding:NSUTF8StringEncoding];
    return [NSJSONSerialization JSONObjectWithData:objectData
                                           options:NSJSONReadingMutableContainers
                                             error:&jsonError];
}
+(UIColor*) colorFromHexString: (NSString*)hexString
{
    unsigned rgbValue = 0;
    NSScanner *scanner = [NSScanner scannerWithString:hexString];
    [scanner setScanLocation:1]; // bypass '#' character
    [scanner scanHexInt:&rgbValue];
    return [UIColor colorWithRed:((rgbValue & 0xFF0000) >> 16)/255.0 green:((rgbValue & 0xFF00) >> 8)/255.0 blue:(rgbValue & 0xFF)/255.0 alpha:1.0];
}
/***
 End Region Util Methods
 ***/

/***
 * Region Pyze Custom Event
 ***/

- (void)postCustomEvent:(CDVInvokedUrlCommand*)command
{
    NSString* eventName = [command.arguments objectAtIndex:0];
    [PyzeCustomEvent postWithEventName:eventName];
}

- (void)postCustomEventWithAttributes:(CDVInvokedUrlCommand*)command
{
    NSString* eventName = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeCustomEvent postWithEventName:eventName
                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postTimedEventWithName:(CDVInvokedUrlCommand*)command {
    NSString* eventName = [command.arguments objectAtIndex:0];
    double timerReference = [[command.arguments objectAtIndex:1] doubleValue];
    [PyzeCustomEvent postTimedWithEventName:eventName
                                   withTimerReference:timerReference];
}


- (void)postTimedEventWithNameAndAttributes:(CDVInvokedUrlCommand*)command {
    NSString* eventName = [command.arguments objectAtIndex:0];
    double timerReference = [[command.arguments objectAtIndex:1] doubleValue];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeCustomEvent postTimedWithEventName:eventName
                                withTimerReference:timerReference
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}
/***
 End Region Pyze Custom Event
 ***/

/***
 * Region PyzeAdvocacy
 ***/

- (void)postRequestFeedback:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAdvocacy postRequestForFeedback:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFeedbackProvided:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAdvocacy postFeedbackProvided:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRequestRating:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAdvocacy postRequestRating:[PyzeCordova getDictionaryFromString:customAttributes]];
}
/***
 End Region PyzeAdvocacy
 ***/

/***
 * Region PyzeAd
 ***/

- (void)postAdRequested:(CDVInvokedUrlCommand*)command {
    NSString* adNetwork = [command.arguments objectAtIndex:0];
    NSString* appScreen = [command.arguments objectAtIndex:1];
    NSString* size = [command.arguments objectAtIndex:2];
    NSString* type = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
    
    [PyzeAd postAdRequested:adNetwork
              fromAppScreen:appScreen
                 withAdSize:size
                     adType:type
             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postAdReceived:(CDVInvokedUrlCommand*)command {
    NSString* adNetwork = [command.arguments objectAtIndex:0];
    NSString* appScreen = [command.arguments objectAtIndex:1];
    NSString* resultCode = [command.arguments objectAtIndex:2];
    Boolean   success = [[command.arguments objectAtIndex:3] boolValue];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeAd postAdReceived:adNetwork
                      fromAppScreen:appScreen
                     withResultCode:resultCode
                          isSuccess:success
                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postAdClicked:(CDVInvokedUrlCommand*)command {
    NSString* adNetwork = [command.arguments objectAtIndex:0];
    NSString* appScreen = [command.arguments objectAtIndex:1];
    NSString* adCode = [command.arguments objectAtIndex:2];
    Boolean   success = [[command.arguments objectAtIndex:3] boolValue];
    NSString* errorCode = [command.arguments objectAtIndex:4];
    NSString* customAttributes = [command.arguments objectAtIndex:5];
             [PyzeAd postAdClicked:adNetwork
                     fromAppScreen:appScreen
                            adCode:adCode
                         isSuccess:success
                     withErrorCode:errorCode
                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 End Region PyzeAd
 ***/

/***
 * Region PyzeAccount
 ***/


- (void)postLoginOffered:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postLoginOffered:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLoginStarted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postLoginStarted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSocialLoginOffered:(CDVInvokedUrlCommand*)command {
    NSString* type = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeAccount postSocialLoginOffered:type
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSocialLoginStarted:(CDVInvokedUrlCommand*)command {
    NSString* type = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeAccount postSocialLoginStarted:type
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSocialLoginCompleted:(CDVInvokedUrlCommand*)command {
    NSString* type = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeAccount postSocialLoginCompleted:type withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postPasswordResetCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postPasswordResetCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRegistrationOffered:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postRegistrationOffered:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRegistrationStarted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postRegistrationStarted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRegistrationCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postRegistrationCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLoginCompleted:(CDVInvokedUrlCommand*)command {
    Boolean success = [[command.arguments objectAtIndex:0] boolValue];
    NSString* errCodeString = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeAccount postLoginCompleted:success
                                 withErrCode:errCodeString
                              withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLogoutCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postLogoutCompleted:true withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postPasswordResetRequest:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeAccount postPasswordResetCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}
/***
 End Region PyzeAccount
 ***/

/***
 * Region PyzeContent
 ***/

- (void)postViewed:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* categoryName = [command.arguments objectAtIndex:1];
    NSString* contentId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeContent postViewed:contentName
                            category:categoryName
                 withUniqueContentId:contentId
                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];}


- (void)postSearched:(CDVInvokedUrlCommand*)command {
    NSString* searchString = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeContent postSearched:searchString
                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRatedOn5PointScale:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* categoryName = [command.arguments objectAtIndex:1];
    NSString* contentId = [command.arguments objectAtIndex:2];
    NSDecimalNumber *rating = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
    [PyzeContent postRatedOn5PointScale:contentName
                               category:categoryName
                    withUniqueContentId:contentId
                          contentRating:rating
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRatedThumbsUp:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* categoryName = [command.arguments objectAtIndex:1];
    NSString* contentId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeContent postRatedThumbsUp:contentName
                                   category:categoryName
                        withUniqueContentId:contentId
                             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRatedThumbsDown:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* categoryName = [command.arguments objectAtIndex:1];
    NSString* contentId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeContent postRatedThumbsDown:contentName
                                     category:categoryName
                          withUniqueContentId:contentId
                               withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];}

/***
 End Region PyzeContent
 ***/

/***
 * Region PyzeMessaging
 ***/

- (void)postMessageSent:(CDVInvokedUrlCommand*)command {
    NSString* uniqueId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
        [PyzeMessaging postMessageSent:uniqueId
                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postMessageSentOfType:(CDVInvokedUrlCommand*)command {
    PyzeMessageType messageType = [[command.arguments objectAtIndex:0] intValue];
    NSString* uniqueId = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeMessaging postMessageSentOfType:messageType
                                     withUniqueId:uniqueId
                                   withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postMessageReceived:(CDVInvokedUrlCommand*)command {
    NSString* uniqueId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeMessaging postMessageReceived:uniqueId
                                 withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postMessageNewConversation:(CDVInvokedUrlCommand*)command {
    NSString* uniqueId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeMessaging postMessageNewConversation:uniqueId
                                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postMessageVoiceCall:(CDVInvokedUrlCommand*)command {
    NSString* uniqueId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeMessaging postMessageVoiceCall:uniqueId
                                  withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeMessaging
 ***/


/***
 * Region PyzeInAppPurchaseRevenue
 ***/

- (void)postPriceListViewed:(CDVInvokedUrlCommand*)command {
    NSString* appScreenRequestFromId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeInAppPurchaseRevenue postPriceListViewViewed:appScreenRequestFromId
                                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}


- (void)postBuyItem:(CDVInvokedUrlCommand*)command {
    NSString* itemName = [command.arguments objectAtIndex:0];
    NSDecimalNumber* price = [command.arguments objectAtIndex:1];
    NSString* currency = [command.arguments objectAtIndex:2];
    NSString* itemType = [command.arguments objectAtIndex:3];
    NSString* itemSKU = [command.arguments objectAtIndex:4];
    NSString* quantity = [command.arguments objectAtIndex:5];
    Boolean status = [[command.arguments objectAtIndex:6] boolValue];
    NSString* appScreenRequestFromId = [command.arguments objectAtIndex:7];
    NSString* successOrErrorCode = [command.arguments objectAtIndex:8];
    NSString* customAttributes = [command.arguments objectAtIndex:9];
    
             [PyzeInAppPurchaseRevenue postBuyItem:itemName
                                             price:price
                                          currency:currency
                                          itemType:itemType
                                           itemSKU:itemSKU
                                          quantity:quantity
                                         requestId:appScreenRequestFromId
                                            status:status
                                       successCode:successOrErrorCode
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBuyItemShort:(CDVInvokedUrlCommand*)command {
    NSString* itemName = [command.arguments objectAtIndex:0];
    NSDecimalNumber* price = [command.arguments objectAtIndex:1];
    NSString* currencyISO4217Code = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];

             [PyzeInAppPurchaseRevenue postBuyItem:itemName
                                             price:price
                                          currency:currencyISO4217Code
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBuyItemUSD:(CDVInvokedUrlCommand*)command {
    NSString* itemName = [command.arguments objectAtIndex:0];
    NSDecimalNumber* price = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeInAppPurchaseRevenue postBuyItemInUSD:itemName
                                         price:price
                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeInAppPurchaseRevenue
 ***/


/***
 * Region PyzeTasks
 ***/

- (void)postAddToCalendarWithAttributes:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeTasks addToCalendarwithAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeTasks
 ***/

/***
 * Region PyzeSocial
 ***/

- (void)postSocialContentShareForNetworkName:(CDVInvokedUrlCommand*)command {
    NSString* socialNetworkName = [command.arguments objectAtIndex:0];
    NSString* contentReference = [command.arguments objectAtIndex:1];
    NSString* category = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
    
    [PyzeSocial postSocialContentShareForNetworkName:socialNetworkName
                                 forContentReference:contentReference
                                            category:category
                                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLiked:(CDVInvokedUrlCommand*)command {
    NSString* socialNetworkName = [command.arguments objectAtIndex:0];
    NSString* contentReference = [command.arguments objectAtIndex:1];
    NSString* category = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeSocial postLiked:socialNetworkName
               forContentReference:contentReference
                          category:category
                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFollowed:(CDVInvokedUrlCommand*)command {
    NSString* socialNetworkName = [command.arguments objectAtIndex:0];
    NSString* contentReference = [command.arguments objectAtIndex:1];
    NSString* category = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
    [PyzeSocial postFollowed:socialNetworkName
         forContentReference:contentReference
                    category:category
              withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSubscribed:(CDVInvokedUrlCommand*)command {
    NSString* socialNetworkName = [command.arguments objectAtIndex:0];
    NSString* contentReference = [command.arguments objectAtIndex:1];
    NSString* category = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeSocial postSubscribed:socialNetworkName
                    forContentReference:contentReference
                               category:category
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postInvitedFriends:(CDVInvokedUrlCommand*)command {
    NSString* socialNetworkName = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeSocial postInvitedFriend:socialNetworkName
                            withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFoundFriends:(CDVInvokedUrlCommand*)command {
    NSString* source = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeSocial postFoundFriends:source
                           withAtrributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}
/***
 End Region PyzeSocial
 ***/

/***
 * Region PyzeCommerceDiscovery
 ***/

- (void)pyzeCommerceDiscoveryPostSearched:(CDVInvokedUrlCommand*)command {
    NSString* searchString = [command.arguments objectAtIndex:0];
    NSNumber* latency = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeCommerceDiscovery postSearched:searchString
                                     withLatency:latency
                                  withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBrowsedCategory:(CDVInvokedUrlCommand*)command {
    NSString* category = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeCommerceDiscovery postBrowsedCategory:category
                                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBrowsedDeals:(CDVInvokedUrlCommand*)command {
    NSString* uniqueDealId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeCommerceDiscovery postBrowsedDeals:uniqueDealId
                                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBrowsedRecommendations:(CDVInvokedUrlCommand*)command {
    NSString* uniqueRecommendationID = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeCommerceDiscovery postBrowsedRecommendations:uniqueRecommendationID
                                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBrowsedPrevOrders:(CDVInvokedUrlCommand*)command {
    NSString* rangeStart = [command.arguments objectAtIndex:0];
    NSString* rangeEnd = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeCommerceDiscovery postBrowsedPrevOrders:rangeStart
                                         withEnd:rangeEnd
                                  withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceDiscovery
 ***/

/***
 * Region PyzeCommerceCuratedList
 ***/

- (void)postCreated:(CDVInvokedUrlCommand*)command {
    NSString* uniqueCuratedListID = [command.arguments objectAtIndex:0];
    NSString* curatedListType = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeCommerceCuratedList postCreated:uniqueCuratedListID
                                withType:curatedListType
                          withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBrowsed:(CDVInvokedUrlCommand*)command {
    NSString* curatedList = [command.arguments objectAtIndex:0];
    NSString* curatedListCreator = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeCommerceCuratedList postBrowsed:curatedList
                                      withCreator:curatedListCreator
                                   withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postAddedItem:(CDVInvokedUrlCommand*)command {
    NSString* uniqueCuratedListId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
    [PyzeCommerceCuratedList postAddedItem:uniqueCuratedListId
                                        withCategory:itemCategory
                                          withItemId:itemId
                                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRemovedItem:(CDVInvokedUrlCommand*)command {
    NSString* uniqueCuratedListId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeCommerceCuratedList postRemovedItem:uniqueCuratedListId
                                         withListType:itemCategory
                                           withItemID:itemId
                                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postShared:(CDVInvokedUrlCommand*)command {
    NSString* curatedList = [command.arguments objectAtIndex:0];
    NSString* curatedListCreator = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeCommerceCuratedList postShared:curatedList
                                     withCreator:curatedListCreator
                                  withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postPublished:(CDVInvokedUrlCommand*)command {
    NSString* curatedList = [command.arguments objectAtIndex:0];
    NSString* curatedListCreator = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeCommerceCuratedList postPublished:curatedList
                                        withCreator:curatedListCreator
                                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceCuratedList
 ***/


/***
 * Region PyzeCommerceWishList
 ***/

- (void)pyzeCommerceWishListPostCreated:(CDVInvokedUrlCommand*)command {
    NSString* uniqueWishListId = [command.arguments objectAtIndex:0];
    NSString* wishListType = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeCommerceWishList postCreated:uniqueWishListId
                     withWishListType:wishListType
                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeCommerceWishListPostBrowsed:(CDVInvokedUrlCommand*)command {
    NSString* uniqueWishListId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];

    [PyzeCommerceWishList postBrowsed:uniqueWishListId
                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeCommerceWishListPostAddedItem:(CDVInvokedUrlCommand*)command {
    NSString* uniqueWishListId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
    [PyzeCommerceWishList postAddedItem:uniqueWishListId
                       withItemCategory:itemCategory
                             withItemId:itemId
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeCommerceWishListPostRemovedItem:(CDVInvokedUrlCommand*)command {
    NSString* uniqueWishListId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];

             [PyzeCommerceWishList postRemovedItem:uniqueWishListId
                                  withItemCategory:itemCategory
                                        withItemId:itemId
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeCommerceWishListPostShared:(CDVInvokedUrlCommand*)command {
    NSString* uniqueWishListId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeCommerceWishList postShared:uniqueWishListId
                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceWishList
 ***/


/***
 * Region PyzeCommerceBeacon
 ***/

- (void)postEnteredRegion:(CDVInvokedUrlCommand*)command {
    NSString* beaconUUID = [command.arguments objectAtIndex:0];
    NSString* beaconMajor = [command.arguments objectAtIndex:1];
    NSString* beaconMinor = [command.arguments objectAtIndex:2];
    NSString* uniqueRegionIdentifier = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];

             [PyzeCommerceBeacon postEnteredRegion:beaconUUID
                                   withBeaconMajor:beaconMajor
                                   withBeaconMinor:beaconMinor
                        withUniqueRegionIdentifier:uniqueRegionIdentifier
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postExitedRegion:(CDVInvokedUrlCommand*)command {
    NSString* beaconUUID = [command.arguments objectAtIndex:0];
    NSString* beaconMajor = [command.arguments objectAtIndex:1];
    NSString* beaconMinor = [command.arguments objectAtIndex:2];
    NSString* uniqueRegionIdentifier = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeCommerceBeacon postExitedRegion:beaconUUID
                                  withBeaconMajor:beaconMajor
                                  withBeaconMinor:beaconMinor
                       withUniqueRegionIdentifier:uniqueRegionIdentifier
                                   withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postTransactedRegion:(CDVInvokedUrlCommand*)command {
    NSString* beaconUUID = [command.arguments objectAtIndex:0];
    NSString* beaconMajor = [command.arguments objectAtIndex:1];
    NSString* beaconMinor = [command.arguments objectAtIndex:2];
    NSString* uniqueRegionIdentifier = [command.arguments objectAtIndex:3];
    NSString* proximity = [command.arguments objectAtIndex:4];
    NSString* actionId = [command.arguments objectAtIndex:5];
    NSString* customAttributes = [command.arguments objectAtIndex:6];

             [PyzeCommerceBeacon postTransactedInRegion:beaconUUID
                                        withBeaconMajor:beaconMajor
                                        withBeaconMinor:beaconMinor
                             withUniqueRegionIdentifier:uniqueRegionIdentifier
                                          withProximity:proximity
                                           withActionId:actionId
                                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}

/***
 * End Region PyzeCommerceBeacon
 ***/

/***
 * Region PyzeCommerceCart
 ***/

- (void)postAddItem:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeCommerceCart postAddItem:cartId
                          withItemCategory:itemCategory
                                withItemId:itemId
                            withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postAddItemFromDeals:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* uniqueDealId = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeCommerceCart postAddItemFromDeals:cartId
                                   withItemCategory:itemCategory
                                         withItemId:itemId
                                   withUniqueDealId:uniqueDealId
                                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postAddItemFromWishList:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* uniqueWishListId = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeCommerceCart postAddItemFromWishList:cartId
                                      withItemCategory:itemCategory
                                            withItemId:itemId
                                  withUniqueWishListId:uniqueWishListId
                                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}


- (void)postAddItemFromCuratedList:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* uniqueCuratedListId = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];

             [PyzeCommerceCart postAddItemFromCuratedList:cartId
                                         withItemCategory:itemCategory
                                               withItemId:itemId
                                  withUniqueCuratedListId:uniqueCuratedListId
                                           withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}


- (void)postAddItemFromRecommendations:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* uniqueRecommendationId = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeCommerceCart postAddItemFromRecommendations:cartId
                                             withItemCategory:itemCategory
                                                   withItemId:itemId
                                   withUniqueRecommendationId:uniqueRecommendationId
                                               withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}


- (void)postAddItemFromPreviousOrders:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* previousOrderId = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeCommerceCart postAddItemFromPreviousOrders:cartId
                                            withItemCategory:itemCategory
                                                  withItemId:itemId
                                         withPreviousOrderId:previousOrderId
                                              withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postAddItemFromSearchResults:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* searchString = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeCommerceCart postAddItemFromSearchResults:cartId
                                           withItemCategory:itemCategory
                                                 withItemId:itemId
                                           withSearchString:searchString
                                             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}


- (void)postAddItemFromSubscriptionList:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* uniqueSubscriptionId = [command.arguments objectAtIndex:3];
    NSString* customAttributes = [command.arguments objectAtIndex:4];
             [PyzeCommerceCart postAddItemFromSubscriptionList:cartId
                                              withItemCategory:itemCategory
                                                    withItemId:itemId
                                              withUniqueDealId:uniqueSubscriptionId
                                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRemoveItemFromCart:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* itemCategory = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeCommerceCart postRemoveItemFromCart:cartId
                                     withItemCategory:itemCategory
                                           withItemId:itemId
                                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}


- (void)postView:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeCommerceCart postView:cartId
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postShare:(CDVInvokedUrlCommand*)command {
    NSString* cartId = [command.arguments objectAtIndex:0];
    NSString* sharedWith = [command.arguments objectAtIndex:1];
    NSString* itemId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeCommerceCart postShare:cartId
                      withItemSharedWith:sharedWith
                              withItemId:itemId
                          withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 End Region PyzeCommerceCart
 ***/


/***
 * Region PyzeCommerceItem
 ***/

- (void)postViewedItem:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceItem postViewedItem:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postScannedItem:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceItem postScannedItem:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postViewedReviews:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceItem postViewedReviews:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postViewedDetails:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceItem postViewedDetails:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postViewedPrice:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceItem postViewedPrice:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postItemShare:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceItem postItemShareItem:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postItemRateOn5Scale:(CDVInvokedUrlCommand*)command {
        NSString* itemSKU = [command.arguments objectAtIndex:0];
        NSString* rating = [command.arguments objectAtIndex:1];
        NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeCommerceItem postItemRateOn5Scale:itemSKU
                                         withRating:rating
                                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceItem
 ***/


/***
 * Region PyzeCommerceCheckout
 ***/

- (void)postCheckoutStarted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceCheckout postCheckoutStarted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postCheckoutCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceCheckout postCheckoutCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postCheckoutAbandoned:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceCheckout postCheckoutAbandoned:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postCheckoutFailed:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceCheckout postCheckoutFailed:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceCheckout
 ***/


/***
 * Region PyzeCommerceShipping
 ***/

- (void)postShippingStarted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceShipping postShippingStarted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postShippingCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceShipping postShippingCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postShippingAbandoned:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceShipping postShippingAbandoned:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postShippingFailed:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceShipping postShippingFailed:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceShipping
 ***/


/***
 * Region PyzeCommerceBilling
 ***/

- (void)postBillingStarted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceBilling postBillingStarted:[PyzeCordova getDictionaryFromString:customAttributes]];
}

- (void)postBillingCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceBilling postBillingCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBillingAbandoned:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceBilling postBillingAbandoned:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postBillingFailed:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommerceBilling postBillingFailed:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceBilling
 ***/


/***
 * Region PyzeCommercePayment
 ***/

- (void)postPaymentStarted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommercePayment postPaymentStarted:[PyzeCordova getDictionaryFromString:customAttributes]];
}

- (void)postPaymentCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommercePayment postPaymentCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postPaymentAbandoned:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommercePayment postPaymentAbandoned:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postPaymentFailed:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeCommercePayment postPaymentFailed:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommercePayment
 ***/


/***
 * Region PyzeExplicitActivation
 ***/

- (void)postWithAttributes:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeExplicitActivation post:[PyzeCordova getDictionaryFromString:customAttributes]];
}



- (void)post:(CDVInvokedUrlCommand*)command {
    [PyzeExplicitActivation post];
}

/***
 * End Region PyzeExplicitActivation
 ***/


/***
 * Region PyzeGaming
 ***/

- (void)postLevelStarted:(CDVInvokedUrlCommand*)command {
    NSString* level = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeGaming postLevelStarted:level
                           withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLevelEnded:(CDVInvokedUrlCommand*)command {
    NSString* level = [command.arguments objectAtIndex:0];
    NSString* score = [command.arguments objectAtIndex:1];
    NSString* success = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeGaming postLevelEnded:level
                              withScore:score
                   withSuccessOrFailure:success
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];}


- (void)postPowerUpConsumed:(CDVInvokedUrlCommand*)command {
    NSString* level = [command.arguments objectAtIndex:0];
    NSString* type = [command.arguments objectAtIndex:1];
    NSString* value = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeGaming postPowerUpConsumed:level
                                    withType:type
                                   withValue:value
                              withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postInGameItemPurchased:(CDVInvokedUrlCommand*)command {
    NSString* uniqueItemId = [command.arguments objectAtIndex:0];
    NSString* itemType = [command.arguments objectAtIndex:1];
    NSString* value = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeGaming postInGameItemPurchased:uniqueItemId
                                    withItemType:itemType
                                   withItemValue:value
                                  withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postAchievementEarned:(CDVInvokedUrlCommand*)command {
    NSString* uniqueAchievementId = [command.arguments objectAtIndex:0];
    NSString* type = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeGaming postAchievementEarned:uniqueAchievementId
                                      withType:type
                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSummaryViewed:(CDVInvokedUrlCommand*)command {
    NSString* level = [command.arguments objectAtIndex:0];
    NSString* type = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeGaming postSummaryViewed:level
                                 withScore:type
                            withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLeaderBoardViewed:(CDVInvokedUrlCommand*)command {
    NSString* level = [command.arguments objectAtIndex:0];
    NSString* score = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeGaming postLeaderBoardViewed:level
                                     withScore:score
                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postScorecardViewed:(CDVInvokedUrlCommand*)command {
    NSString* level = [command.arguments objectAtIndex:0];
    NSString* score = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeGaming postScorecardViewed:level
                                   withScore:score
                              withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postHelpViewed:(CDVInvokedUrlCommand*)command {
    NSString* helpTopicId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeGaming postHelpViewed:helpTopicId
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postTutorialViewed:(CDVInvokedUrlCommand*)command {
    NSString* helpTopicId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeGaming postTutorialViewed:helpTopicId
                             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFriendChallenged:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeGaming postFriendChallenged:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postChallengeAccepted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeGaming postChallengeAccepted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postChallengeDeclined:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeGaming postChallengeDeclined:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postGameStarted:(CDVInvokedUrlCommand*)command {
    NSString* level = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeGaming postGameStart:level
                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postGameEnd:(CDVInvokedUrlCommand*)command {
    NSString* levelsPlayed = [command.arguments objectAtIndex:0];
    NSString* levelsWon = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeGaming postGameEnd:levelsPlayed
                       withLevelsWon:levelsWon
                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeGaming
 ***/

/***
 * Region PyzeHealthAndFitness
 ***/

- (void)postStarted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeHealthAndFitness postStarted:[PyzeCordova getDictionaryFromString:customAttributes]];
}

- (void)postEnded:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeHealthAndFitness postEnded:[PyzeCordova getDictionaryFromString:customAttributes]];
}



- (void)postAchievementReceived:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeHealthAndFitness postAchievementReceived:[PyzeCordova getDictionaryFromString:customAttributes]];
}



- (void)postStepGoalCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeHealthAndFitness postStepGoalCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}



- (void)postGoalCompleted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeHealthAndFitness postGoalCompleted:[PyzeCordova getDictionaryFromString:customAttributes]];
}



- (void)postChallengedFriend:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeHealthAndFitness postChallengedFriend:[PyzeCordova getDictionaryFromString:customAttributes]];
}



- (void)pyzeHealthAndFitnessPostChallengeAccepted:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeHealthAndFitness postChallengeAccepted:[PyzeCordova getDictionaryFromString:customAttributes]];
}


/***
 * End Region PyzeHealthAndFitness
 ***/


/***
 * Region PyzeMedia
 ***/

- (void)pyzeMediaPostPlayedMedia:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* type = [command.arguments objectAtIndex:1];
    NSString* categoryName = [command.arguments objectAtIndex:2];
    NSString* percent = [command.arguments objectAtIndex:3];
    NSString* contentId = [command.arguments objectAtIndex:4];
    NSString* customAttributes = [command.arguments objectAtIndex:5];
             [PyzeMedia postPlayedMedia:contentName
                              mediaType:type
                               category:categoryName
                          percentPlayed:percent
                    withUniqueContentId:contentId
                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeMediaPostSearched:(CDVInvokedUrlCommand*)command {
    NSString* searchString = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeMedia postSearched:searchString
                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRateOn5PointScale:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* categoryName = [command.arguments objectAtIndex:1];
    NSString* contentId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeMedia postRatedOn5PointScale:contentName
                                      category:categoryName
                           withUniqueContentId:contentId
                                 contentRating:[NSDecimalNumber zero]
                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeMediaPostRatedThumbsUp:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* categoryName = [command.arguments objectAtIndex:1];
    NSString* contentId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeMedia postRatedThumbsUp:contentName
                                 category:categoryName
                      withUniqueContentId:contentId
                           withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeMediaPostRatedThumbsDown:(CDVInvokedUrlCommand*)command {
    NSString* contentName = [command.arguments objectAtIndex:0];
    NSString* categoryName = [command.arguments objectAtIndex:1];
    NSString* contentId = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeMedia postRatedThumbsDown:contentName
                                   category:categoryName
                        withUniqueContentId:contentId
                             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeMedia
 ***/


/***
 * Region PyzeBitcoin
 ***/

- (void)postSentBitCoins:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeBitcoin postSentBitcoins:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRequestedBitCoins:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeBitcoin postRequestedBitcoins:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postReceivedBitCoins:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeBitcoin postReceivedBitcoins:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postImportedPrivateKey:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeBitcoin postImportedPrivateKey:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postViewedTransaction:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeBitcoin postViewedTransactions:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postScannedPrivateKey:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeBitcoin postScannedPrivateKey:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeBitcoin
 ***/


/***
 * Region PyzeCommerceRevenue
 ***/

- (void)postRevenue:(CDVInvokedUrlCommand*)command {
    NSNumber* revenue = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeCommerceRevenue postRevenue:revenue withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRevenueDetailed:(CDVInvokedUrlCommand*)command {
    NSNumber* revenue = [command.arguments objectAtIndex:0];
    NSString* paymentInstrument = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeCommerceRevenue postRevenue:revenue withPaymentInstrument:paymentInstrument withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRevenueUsingApplePay:(CDVInvokedUrlCommand*)command {
    NSNumber* revenue = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeCommerceRevenue postRevenueUsingApplePay:revenue withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRevenueUsingSamsungPay:(CDVInvokedUrlCommand*)command {
    NSNumber* revenue = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeCommerceRevenue postRevenueUsingSamsungPay:revenue withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRevenueUsingGooglePay:(CDVInvokedUrlCommand*)command {
    NSNumber* revenue = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeCommerceRevenue postRevenueUsingGooglePay:revenue withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceRevenue
 ***/


/***
 * Region PyzeDrone
 ***/

- (void)postPreflightCheckCompleted:(CDVInvokedUrlCommand*)command {
    NSString* overallStatus = [command.arguments objectAtIndex:0];
    NSString* storageStatus = [command.arguments objectAtIndex:1];
    NSInteger droneBatteryChargePercent = [[command.arguments objectAtIndex:2] intValue];
    NSInteger deviceBatteryChargePercent = [[command.arguments objectAtIndex:3] intValue];
    NSString* calibrationStatus = [command.arguments objectAtIndex:4];
    NSString* gpsStatus = [command.arguments objectAtIndex:5];
    NSString* customAttributes = [command.arguments objectAtIndex:6];
             [PyzeDrone postPreflightCheckCompleted:overallStatus
                                  withStorageStatus:storageStatus
                                   withDroneBattery:droneBatteryChargePercent
                             withTransmitterBattery:deviceBatteryChargePercent
                              withCalibrationStatus:calibrationStatus
                                      withGPSStatus:gpsStatus
                                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postInflightCheckCompleted:(CDVInvokedUrlCommand*)command {
    NSString* overallStatus = [command.arguments objectAtIndex:0];
    NSString* rollStatus = [command.arguments objectAtIndex:1];
    NSString* pitchStatus = [command.arguments objectAtIndex:2];
    NSString* yawStatus = [command.arguments objectAtIndex:3];
    NSString* throttleStatus = [command.arguments objectAtIndex:4];
    NSString* trimmingSettings = [command.arguments objectAtIndex:5];
    NSString* customAttributes = [command.arguments objectAtIndex:6];
             [PyzeDrone postInflightCheckCompleted:overallStatus
                                          withRoll:rollStatus
                                         withPitch:pitchStatus
                                           withYaw:yawStatus
                                      withThrottle:throttleStatus
                                          withTrim:trimmingSettings
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postConnected:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeDrone postConnected:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postDisconnected:(CDVInvokedUrlCommand*)command {
    NSString* code = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postDisconnected:code
                          withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];}


- (void)postAirborne:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postAirborne:status
                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLanded:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postLanded:status
                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFlightPathCreated:(CDVInvokedUrlCommand*)command {
    NSString* uniqueFlightPathId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postFlightPathCreated:uniqueFlightPathId
                               withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFlightPathUploaded:(CDVInvokedUrlCommand*)command {
    NSString* uniqueFlightPathId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postFlightPathUploaded:uniqueFlightPathId
                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFlightPathEdited:(CDVInvokedUrlCommand*)command {
    NSString* uniqueFlightPathId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postFlightPathEdited:uniqueFlightPathId
                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFlightPathDeleted:(CDVInvokedUrlCommand*)command {
    NSString* uniqueFlightPathId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postFlightPathDeleted:uniqueFlightPathId
                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFlightPathCompleted:(CDVInvokedUrlCommand*)command {
    NSString* uniqueFlightPathId = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postFlightPathCompleted:uniqueFlightPathId
                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFirstPersonViewEnabled:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postFirstPersonViewEnabled:status
           withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postFirstPersonViewDisabled:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postFirstPersonViewDisabled:status
           withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postStartedAerialVideo:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postStartedAerialVideo:status
           withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postStartedAerialVideoDetailed:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* videoIdentifer = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeDrone postStartedAerialVideo:status
                    videoIdentifer: videoIdentifer
                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];

}


- (void)postStoppedAerialVideo:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* secondsLength = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeDrone postStoppedAerialVideo:status
                                    withLength:secondsLength
                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postTookAerialPicture:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postTookAerialPicture:status
                            withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postStartedAerialTimelapse:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSInteger totalshots = [[command.arguments objectAtIndex:1] intValue];
    NSInteger secondsBetweenShots = [[command.arguments objectAtIndex:2] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeDrone postStartedAerialTimelapse:status
                                        totalShots:totalshots
                                 delayBetweenShots:secondsBetweenShots
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postStoppedAerialTimelapse:(CDVInvokedUrlCommand*)command {
    NSString* status = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeDrone postStoppedAerialTimelapse:status
                      withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postRequestedReturnToBase:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeDrone postRequestedReturnToBase:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSwitchedToHelicopterFlyingMode:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeDrone postSwitchedToHelicopterFlyingMode:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSwitchedToAltitudeFlyingMode:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeDrone postSwitchedToAttitudeFlyingMode:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSwitchedToGPSHoldFlyingMode:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeDrone postSwitchedToGPSHoldFlyingMode:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSwitchedToCustomFlyingMode:(CDVInvokedUrlCommand*)command {
    NSInteger mode = [[command.arguments objectAtIndex:0] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postSwitchedToCustomFlyingMode:mode
                                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSetMaxAltitude:(CDVInvokedUrlCommand*)command {
    NSInteger altitudeInMeters = [[command.arguments objectAtIndex:0] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postSetMaxAltitude:(NSInteger)altitudeInMeters
                            withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSetAutoReturnInSeconds:(CDVInvokedUrlCommand*)command {
    NSInteger seconds = [[command.arguments objectAtIndex:0] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postSetAutoReturnInSeconds:(NSInteger)seconds
                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSetAutoReturnWhenLowMemory:(CDVInvokedUrlCommand*)command {
    NSInteger memoryLeftInKilobytes = [[command.arguments objectAtIndex:0] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postSetAutoReturnWhenLowMemory:(NSInteger)memoryLeftInKilobytes
                                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postSetAutoReturnWhenLowBattery:(CDVInvokedUrlCommand*)command {
    NSInteger batterylevelPercent = [[command.arguments objectAtIndex:0] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeDrone postSetAutoReturnWhenLowBattery:(NSInteger)batterylevelPercent
                                         withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeDrone
 ***/


/***
 * Region PyzeWeatherAndForecast
 ***/

- (void)postWeatherRequestedForType:(CDVInvokedUrlCommand*)command {
    NSInteger type = [[command.arguments objectAtIndex:0] intValue];
    NSInteger howManyDays = [[command.arguments objectAtIndex:1] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeWeatherAndForecast postWeatherRequestedForType:(PyzeWeatherRequestType)type
                                                         forDays:(NSInteger)howManyDays
                                                  withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherHistoricalRequest:(CDVInvokedUrlCommand*)command {
    NSTimeInterval startInterval = [[command.arguments objectAtIndex:0] longValue];
    NSTimeInterval endInterval = [[command.arguments objectAtIndex:1] longValue];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeWeatherAndForecast postWeatherHistoricalRequest:(NSTimeInterval)startInterval
                                                      withEndDate:(NSTimeInterval)endInterval
                                                   withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherStationsRequestWithClusterData:(CDVInvokedUrlCommand*)command {
    
    NSString* clusterData = [command.arguments objectAtIndex:0];
    NSString* point = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    
             NSError *jsonError;
             NSData *objectData = [point dataUsingEncoding:NSUTF8StringEncoding];
             NSDictionary * dictionary = [NSJSONSerialization JSONObjectWithData:objectData
                                                                         options:NSJSONReadingMutableContainers
                                                                           error:&jsonError];
             PyzeGeoPoint * pyzeGeoPoint = NULL;
             pyzeGeoPoint->GeoPointLat = [dictionary[@"lat"] floatValue];
             pyzeGeoPoint->GeoPointLon = [dictionary[@"lng"] floatValue];
    
             [PyzeWeatherAndForecast postWeatherStationsRequestWithClusterData:clusterData
                                                                     atGeoPoint:pyzeGeoPoint
                                                                 withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherMapLayersRequested:(CDVInvokedUrlCommand*)command {
    NSString* layerName = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeWeatherAndForecast postWeatherMapLayersRequested:layerName
                                                    withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherRequestForUVIndexAtPoint:(CDVInvokedUrlCommand*)command {
    NSString* point = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    NSError *jsonError;
    NSData *objectData = [point dataUsingEncoding:NSUTF8StringEncoding];
    NSDictionary * dictionary = [NSJSONSerialization JSONObjectWithData:objectData
                                                                options:NSJSONReadingMutableContainers
                                                                  error:&jsonError];
    PyzeGeoPoint * pyzeGeoPoint = NULL;
    pyzeGeoPoint->GeoPointLat = [dictionary[@"lat"] floatValue];
    pyzeGeoPoint->GeoPointLon = [dictionary[@"lng"] floatValue];
             [PyzeWeatherAndForecast postWeatherRequestForUVIndexAtPoint:pyzeGeoPoint
                                                          withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherResponseForType:(CDVInvokedUrlCommand*)command {
    NSInteger type = [[command.arguments objectAtIndex:0] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeWeatherAndForecast postWeatherResponseForType:(PyzeWeatherRequestType)type
                                                 withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherResponseForHistoricalData:(CDVInvokedUrlCommand*)command{
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeWeatherAndForecast postWeatherResponseForHistoricalData:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherStationResponseData:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeWeatherAndForecast postWeatherStationResponseData:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherMapLayersResponse:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeWeatherAndForecast postWeatherMapLayersResponse:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postWeatherResponseForUVIndex:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeWeatherAndForecast postWeatherResponseForUVIndex:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postForecastRequestForKeywords:(CDVInvokedUrlCommand*)command {
    NSString* commaSeperatedKeywords = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeWeatherAndForecast postForecastRequestForKeywords:commaSeperatedKeywords
                                            withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postForecastResponseForKeywordsShort:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeWeatherAndForecast postForecastResponseForKeywords:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postForecastFetch:(CDVInvokedUrlCommand*)command {
    NSInteger nDays = [[command.arguments objectAtIndex:0] intValue];
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeWeatherAndForecast postForecastFetch:(NSInteger)nDays
                               withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postForecastFetchResponse:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeWeatherAndForecast postForecastFetchResponse:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeWeatherAndForecast
 ***/


/***
 * Region PyzeSupport
 ***/


- (void)postRequestedPhoneCallback:(CDVInvokedUrlCommand*)command {
    NSString* customAttributes = [command.arguments objectAtIndex:0];
    [PyzeSupport postRequestedPhoneCallback:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLiveChatStartedWithTopic:(CDVInvokedUrlCommand*)command {
    NSString* topic = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
             [PyzeSupport postLiveChatStartedWithTopic:topic
                                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postLiveChatEndedWithTopic:(CDVInvokedUrlCommand*)command {
    NSString* topic = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeSupport postLiveChatEndedWithTopic:topic
                               withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

- (void)postTicketCreated:(CDVInvokedUrlCommand*)command {
    NSString* itemID = [command.arguments objectAtIndex:0];
    NSString* topic = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeSupport postTicketCreated:itemID
                                  withTopic:topic
                             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];}


- (void)postFeedbackReceived:(CDVInvokedUrlCommand*)command {
    NSString* feedback = [command.arguments objectAtIndex:0];
    NSString* customAttributes = [command.arguments objectAtIndex:1];
    [PyzeSupport postFeedbackReceived:feedback
                             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)postQualityOfServiceRated:(CDVInvokedUrlCommand*)command {
    NSString* comment = [command.arguments objectAtIndex:0];
    NSString* rating = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeSupport postQualityOfServiceRated:comment
                                       rateOn5Scale:rating
                                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeSupport
 ***/


/***
 * Region PyzeCommerceSupport
 ***/

- (void)pyzeCommerceSupportPostLiveChatStartedWithTopic:(CDVInvokedUrlCommand*)command {
    NSString* topic = [command.arguments objectAtIndex:0];
    NSString* orderNumber = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeCommerceSupport postLiveChatStartedWithTopic:topic
                                               withOrderNumber:orderNumber
                                                withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeCommerceSupportPostLiveChatEndedWithTopic:(CDVInvokedUrlCommand*)command {
    NSString* topic = [command.arguments objectAtIndex:0];
    NSString* orderNumber = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeCommerceSupport postLiveChatEndedWithTopic:topic
                                      withOrderNumber:orderNumber
                                       withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeCommerceSupportPostTicketCreated:(CDVInvokedUrlCommand*)command {
    NSString* itemID = [command.arguments objectAtIndex:0];
    NSString* topic = [command.arguments objectAtIndex:1];
    NSString* orderNumber = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeCommerceSupport postTicketCreated:itemID
                                          withTopic:topic
                                    withOrderNumber:orderNumber
                                     withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}


- (void)pyzeCommerceSupportPostFeedbackReceived:(CDVInvokedUrlCommand*)command {
    NSString* feedback = [command.arguments objectAtIndex:0];
    NSString* orderNumber = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
             [PyzeCommerceSupport postFeedbackReceived:feedback
                                       withOrderNumber:orderNumber
                                        withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

- (void)pyzeCommerceSupportPostQualityOfServiceRated:(CDVInvokedUrlCommand*)command {
    NSString* comment = [command.arguments objectAtIndex:0];
    NSString* orderNumber = [command.arguments objectAtIndex:1];
    NSString* rating = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
             [PyzeCommerceSupport postQualityOfServiceRated:comment
                                            withOrderNumber:orderNumber
                                               rateOn5Scale:rating
                                             withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeCommerceSupport
 ***/


/***
 * Region PyzeInAppMessages
 ***/

- (void)showInAppNotification:(CDVInvokedUrlCommand*)command {
             [Pyze showUnreadInAppNotificationUIWithCompletionHandler:^(PyzeInAppStatus *inAppStatus) {
                 CDVPluginResult* pluginResult = nil;
                 pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:[NSString stringWithFormat:@"%@/%@/%@", inAppStatus.title, inAppStatus.urlString, [NSString stringWithFormat: @"%ld", (long)inAppStatus.buttonIndex]]];
                [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
             }];
}

- (void)showInAppNotificatonWithCustomAttributes:(CDVInvokedUrlCommand*)command {
            NSInteger messageType = [[command.arguments objectAtIndex:0] intValue];
            NSString* navigationBarColor = [command.arguments objectAtIndex:1];
             [Pyze showInAppNotificationUIForDisplayMessages:messageType
                                         navigationTextColor:[PyzeCordova colorFromHexString:navigationBarColor]
                                       withCompletionHandler:^(PyzeInAppStatus *inAppStatus) {
                                           CDVPluginResult* pluginResult = nil;
                                           pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:[NSString stringWithFormat:@"%@/%@/%@", inAppStatus.title, inAppStatus.urlString, [NSString stringWithFormat: @"%ld", (long)inAppStatus.buttonIndex]]];
                                           [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
             }];
}

- (void)closeInAppMessage:(CDVInvokedUrlCommand*)command {
    [Pyze dismissInAppNotificationUI:true];
}

- (void)countNewUnFetchedMessages:(CDVInvokedUrlCommand*)command {
    [Pyze countNewUnFetched:^(NSInteger result) {
        CDVPluginResult* pluginResult = nil;
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsNSInteger:result];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }];
}

- (void)getMessageHeaderOfType:(CDVInvokedUrlCommand*)command {
    NSInteger messageType = [[command.arguments objectAtIndex:0] intValue];
    [Pyze getMessageHeadersForType:messageType withCompletionHandler:^(NSArray * result) {
        CDVPluginResult* pluginResult = nil;
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsArray:result];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

    }];
}

- (void)getMessageWithContentID:(CDVInvokedUrlCommand*)command {
    NSString* contentId = [command.arguments objectAtIndex:0];
    NSString* messageId = [command.arguments objectAtIndex:1];
             [Pyze getMessageBodyWithCampaignID:contentId
                                   andMessageID:messageId
                          withCompletionHandler:^(NSDictionary * result) {
                              CDVPluginResult* pluginResult = nil;
                              pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:result];
                              [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

             }];
}

/***
 * End Region PyzeInAppMessages
 ***/

/***
 Region PyzeIdentity
 ***/


- (void) setUserIdentifier:(CDVInvokedUrlCommand*)command {
    NSString* uid = [command.arguments objectAtIndex:0];
    [PyzeIdentity setUserIdentifer:uid];
}

- (void) resetUserIdentifier:(CDVInvokedUrlCommand*)command {
    [PyzeIdentity resetUserIdentifer];
}

- (void) postTraits  :(CDVInvokedUrlCommand*)command {
    NSString* traits = [command.arguments objectAtIndex:0];
    [PyzeIdentity postTraits:[PyzeCordova getDictionaryFromString:traits]];
}

/***
 End Region PyzeIdentity
 ***/


/***
 * Region PyzeSceneFlow
 ***/

- (void)postSecondsOnScene:(CDVInvokedUrlCommand*)command {
    NSString* sceneName = [command.arguments objectAtIndex:0];
    float seconds = [[command.arguments objectAtIndex:1] floatValue];
     [PyzeSceneFlow postSecondsOnScene:sceneName forSeconds:seconds];
}

/***
 * End Region PyzeSceneFlow
 ***/

/***
 * Region PyzePersonalizationIntelligence
 ***/

- (void)getTags:(CDVInvokedUrlCommand*)command {
             [PyzePersonalizationIntelligence getTags:^(NSArray *tagsList) {
                 CDVPluginResult* pluginResult = nil;
                 pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsArray:tagsList];
                 [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
             }];
}

- (void)isTagSet:(CDVInvokedUrlCommand*)command {
    NSString* tag = [command.arguments objectAtIndex:0];
    CDVPluginResult* pluginResult = nil;
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:[PyzePersonalizationIntelligence isTagSet:tag]];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)areAnyTagSet:(CDVInvokedUrlCommand*)command {
    NSString* tags = [command.arguments objectAtIndex:0];
    CDVPluginResult* pluginResult = nil;
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:[PyzePersonalizationIntelligence areAnyTagsSet:[tags componentsSeparatedByString:@","]]];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)areAllTagSet:(CDVInvokedUrlCommand*)command {
    NSString* tags = [command.arguments objectAtIndex:0];
    CDVPluginResult* pluginResult = nil;
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:[PyzePersonalizationIntelligence areAllTagsSet:[tags componentsSeparatedByString:@","]]];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

/***
 * End Region PyzePersonalizationIntelligence
 ***/

/***
 * Region PyzeSMS
 ***/
- (void)registerDevice:(CDVInvokedUrlCommand*)command {
    NSString* phoneNumber = [command.arguments objectAtIndex:0];
    NSString* countryCode = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeSMS postRegisteredDevice:phoneNumber withCountryCode:countryCode withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

- (void)sendVerification:(CDVInvokedUrlCommand*)command {
    NSString* phoneNumber = [command.arguments objectAtIndex:0];
    NSString* verificationCode = [command.arguments objectAtIndex:1];
    NSString* countryCode = [command.arguments objectAtIndex:2];
    NSString* customAttributes = [command.arguments objectAtIndex:3];
    [PyzeSMS postVerification:phoneNumber
         withVerificationCode:verificationCode
              withCountryCode:countryCode
               withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

- (void)unsubscribeDevice:(CDVInvokedUrlCommand*)command {
    NSString* phoneNumber = [command.arguments objectAtIndex:0];
    NSString* countryCode = [command.arguments objectAtIndex:1];
    NSString* customAttributes = [command.arguments objectAtIndex:2];
    [PyzeSMS postUnsubscribeDevice:phoneNumber withCountryCode:countryCode withAttributes:[PyzeCordova getDictionaryFromString:customAttributes]];
}

/***
 * End Region PyzeSMS
 ***/

@end