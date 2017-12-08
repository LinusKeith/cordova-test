//
//  PyzeCordova.h
//  Unity-iPhone
//
//  Created by Jesudas Joseph Lobo on 29/04/16.
//
//

#import <Foundation/Foundation.h>
#import <Pyze/Pyze.h>
#import <Pyze/PyzeEvent.h>
#import <Cordova/CDVPlugin.h>

@interface PyzeCordova : CDVPlugin

/***
* Region Pyze Custom Event
***/
    
- (void)postCustomEvent:(CDVInvokedUrlCommand*)command;

    
- (void)postCustomEventWithAttributes:(CDVInvokedUrlCommand*)command;

    
- (void)postTimedEventWithName:(CDVInvokedUrlCommand*)command;

    
- (void)postTimedEventWithNameAndAttributes:(CDVInvokedUrlCommand*)command;
/***
     End Region Pyze Custom Event
***/

/***
* Region PyzeAdvocacy
***/
    
- (void)postRequestFeedback:(CDVInvokedUrlCommand*)command;

    
- (void)postFeedbackProvided:(CDVInvokedUrlCommand*)command;

    
- (void)postRequestRating:(CDVInvokedUrlCommand*)command;
/***
     End Region PyzeAdvocacy
***/

/***
* Region PyzeAd
***/
    
- (void)postAdRequested:(CDVInvokedUrlCommand*)command;

    
- (void)postAdReceived:(CDVInvokedUrlCommand*)command;

    
- (void)postAdClicked:(CDVInvokedUrlCommand*)command;

/***
 End Region PyzeAd
 ***/

/***
* Region PyzeAccount
***/

    
- (void)postLoginOffered:(CDVInvokedUrlCommand*)command;

    
- (void)postLoginStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postSocialLoginOffered:(CDVInvokedUrlCommand*)command;

    
- (void)postSocialLoginStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postSocialLoginCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postPasswordResetCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postRegistrationOffered:(CDVInvokedUrlCommand*)command;

    
- (void)postRegistrationStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postRegistrationCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postLoginCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postLogoutCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postPasswordResetRequest:(CDVInvokedUrlCommand*)command;
/***
 End Region PyzeAccount
 ***/

/***
* Region PyzeContent
***/
    
- (void)postViewed:(CDVInvokedUrlCommand*)command;

    
- (void)postSearched:(CDVInvokedUrlCommand*)command;

    
- (void)postRatedOn5PointScale:(CDVInvokedUrlCommand*)command;

    
- (void)postRatedThumbsUp:(CDVInvokedUrlCommand*)command;

    
- (void)postRatedThumbsDown:(CDVInvokedUrlCommand*)command;

/***
 End Region PyzeContent
 ***/

/***
* Region PyzeMessaging
***/
    
- (void)postMessageSent:(CDVInvokedUrlCommand*)command;

    
- (void)postMessageSentOfType:(CDVInvokedUrlCommand*)command;

    
- (void)postMessageReceived:(CDVInvokedUrlCommand*)command;

    
- (void)postMessageNewConversation:(CDVInvokedUrlCommand*)command;

    
- (void)postMessageVoiceCall:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeMessaging
***/


/***
* Region PyzeInAppPurchaseRevenue
***/
    
- (void)postPriceListViewed:(CDVInvokedUrlCommand*)command;

    
- (void)postBuyItem:(CDVInvokedUrlCommand*)command;

    
- (void)postBuyItemShort:(CDVInvokedUrlCommand*)command;

    
- (void)postBuyItemUSD:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeInAppPurchaseRevenue
***/


/***
* Region PyzeTasks
***/
    
- (void)postAddToCalendarWithAttributes:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeTasks
***/

/***
* Region PyzeSocial
***/
    
- (void)postSocialContentShareForNetworkName:(CDVInvokedUrlCommand*)command;

    
- (void)postLiked:(CDVInvokedUrlCommand*)command;

    
- (void)postFollowed:(CDVInvokedUrlCommand*)command;

    
- (void)postSubscribed:(CDVInvokedUrlCommand*)command;

    
- (void)postInvitedFriends:(CDVInvokedUrlCommand*)command;

    
- (void)postFoundFriends:(CDVInvokedUrlCommand*)command;
/***
 End Region PyzeSocial
 ***/

/***
* Region PyzeCommerceDiscovery
***/
    
- (void)pyzeCommerceDiscoveryPostSearched:(CDVInvokedUrlCommand*)command;

    
- (void)postBrowsedCategory:(CDVInvokedUrlCommand*)command;

    
- (void)postBrowsedDeals:(CDVInvokedUrlCommand*)command;

    
- (void)postBrowsedRecommendations:(CDVInvokedUrlCommand*)command;

    
- (void)postBrowsedPrevOrders:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceDiscovery
***/

/***
* Region PyzeCommerceCuratedList
***/
    
- (void)postCreated:(CDVInvokedUrlCommand*)command;

    
- (void)postBrowsed:(CDVInvokedUrlCommand*)command;

    
- (void)postAddedItem:(CDVInvokedUrlCommand*)command;

    
- (void)postRemovedItem:(CDVInvokedUrlCommand*)command;

    
- (void)postShared:(CDVInvokedUrlCommand*)command;

    
- (void)postPublished:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceCuratedList
***/


/***
* Region PyzeCommerceWishList
***/
    
- (void)pyzeCommerceWishListPostCreated:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeCommerceWishListPostBrowsed:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeCommerceWishListPostAddedItem:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeCommerceWishListPostRemovedItem:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeCommerceWishListPostShared:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceWishList
***/


/***
* Region PyzeCommerceBeacon
***/
    
- (void)postEnteredRegion:(CDVInvokedUrlCommand*)command;

    
- (void)postExitedRegion:(CDVInvokedUrlCommand*)command;

    
- (void)postTransactedRegion:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceBeacon
***/

/***
* Region PyzeCommerceCart
***/
    
- (void)postAddItem:(CDVInvokedUrlCommand*)command;

    
- (void)postAddItemFromDeals:(CDVInvokedUrlCommand*)command;

    
- (void)postAddItemFromWishList:(CDVInvokedUrlCommand*)command;

    
- (void)postAddItemFromCuratedList:(CDVInvokedUrlCommand*)command;

    
- (void)postAddItemFromRecommendations:(CDVInvokedUrlCommand*)command;

    
- (void)postAddItemFromPreviousOrders:(CDVInvokedUrlCommand*)command;

    
- (void)postAddItemFromSearchResults:(CDVInvokedUrlCommand*)command;

    
- (void)postAddItemFromSubscriptionList:(CDVInvokedUrlCommand*)command;

    
- (void)postRemoveItemFromCart:(CDVInvokedUrlCommand*)command;

    
- (void)postView:(CDVInvokedUrlCommand*)command;

    
- (void)postShare:(CDVInvokedUrlCommand*)command;

/***
 End Region PyzeCommerceCart
 ***/


/***
* Region PyzeCommerceItem
***/
    
- (void)postViewedItem:(CDVInvokedUrlCommand*)command;

    
- (void)postScannedItem:(CDVInvokedUrlCommand*)command;

    
- (void)postViewedReviews:(CDVInvokedUrlCommand*)command;

    
- (void)postViewedDetails:(CDVInvokedUrlCommand*)command;

    
- (void)postViewedPrice:(CDVInvokedUrlCommand*)command;

    
- (void)postItemShare:(CDVInvokedUrlCommand*)command;

    
- (void)postItemRateOn5Scale:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceItem
***/


/***
* Region PyzeCommerceCheckout
***/
    
- (void)postCheckoutStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postCheckoutCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postCheckoutAbandoned:(CDVInvokedUrlCommand*)command;

    
- (void)postCheckoutFailed:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceCheckout
***/


/***
* Region PyzeCommerceShipping
***/
    
- (void)postShippingStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postShippingCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postShippingAbandoned:(CDVInvokedUrlCommand*)command;

    
- (void)postShippingFailed:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceShipping
***/


/***
* Region PyzeCommerceBilling
***/
    
- (void)postBillingStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postBillingCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postBillingAbandoned:(CDVInvokedUrlCommand*)command;

    
- (void)postBillingFailed:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceBilling
***/


/***
* Region PyzeCommercePayment
***/
    
- (void)postPaymentStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postPaymentCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postPaymentAbandoned:(CDVInvokedUrlCommand*)command;

    
- (void)postPaymentFailed:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommercePayment
***/


/***
* Region PyzeExplicitActivation
***/
    
- (void)postWithAttributes:(CDVInvokedUrlCommand*)command;

    
- (void)post:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeExplicitActivation
***/


/***
* Region PyzeGaming
***/
    
- (void)postLevelStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postLevelEnded:(CDVInvokedUrlCommand*)command;

    
- (void)postPowerUpConsumed:(CDVInvokedUrlCommand*)command;

    
- (void)postInGameItemPurchased:(CDVInvokedUrlCommand*)command;

    
- (void)postAchievementEarned:(CDVInvokedUrlCommand*)command;

    
- (void)postSummaryViewed:(CDVInvokedUrlCommand*)command;

    
- (void)postLeaderBoardViewed:(CDVInvokedUrlCommand*)command;

    
- (void)postScorecardViewed:(CDVInvokedUrlCommand*)command;

    
- (void)postHelpViewed:(CDVInvokedUrlCommand*)command;

    
- (void)postTutorialViewed:(CDVInvokedUrlCommand*)command;

    
- (void)postFriendChallenged:(CDVInvokedUrlCommand*)command;

    
- (void)postChallengeAccepted:(CDVInvokedUrlCommand*)command;

    
- (void)postChallengeDeclined:(CDVInvokedUrlCommand*)command;

    
- (void)postGameStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postGameEnd:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeGaming
***/

/***
* Region PyzeHealthAndFitness
***/
    
- (void)postStarted:(CDVInvokedUrlCommand*)command;

    
- (void)postEnded:(CDVInvokedUrlCommand*)command;

    
- (void)postAchievementReceived:(CDVInvokedUrlCommand*)command;

    
- (void)postStepGoalCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postGoalCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postChallengedFriend:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeHealthAndFitnessPostChallengeAccepted:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeHealthAndFitness
***/


/***
* Region PyzeMedia
***/
    
- (void)pyzeMediaPostPlayedMedia:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeMediaPostSearched:(CDVInvokedUrlCommand*)command;

    
- (void)postRateOn5PointScale:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeMediaPostRatedThumbsUp:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeMediaPostRatedThumbsDown:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeMedia
***/


/***
* Region PyzeBitcoin
***/
    
- (void)postSentBitCoins:(CDVInvokedUrlCommand*)command;

    
- (void)postRequestedBitCoins:(CDVInvokedUrlCommand*)command;

    
- (void)postReceivedBitCoins:(CDVInvokedUrlCommand*)command;

    
- (void)postImportedPrivateKey:(CDVInvokedUrlCommand*)command;

    
- (void)postViewedTransaction:(CDVInvokedUrlCommand*)command;

    
- (void)postScannedPrivateKey:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeBitcoin
***/


/***
* Region PyzeCommerceRevenue
***/
    
- (void)postRevenue:(CDVInvokedUrlCommand*)command;

    
- (void)postRevenueDetailed:(CDVInvokedUrlCommand*)command;

    
- (void)postRevenueUsingApplePay:(CDVInvokedUrlCommand*)command;

    
- (void)postRevenueUsingSamsungPay:(CDVInvokedUrlCommand*)command;

    
- (void)postRevenueUsingGooglePay:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceRevenue
***/


/***
* Region PyzeDrone
***/
    
- (void)postPreflightCheckCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postInflightCheckCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postConnected:(CDVInvokedUrlCommand*)command;

    
- (void)postDisconnected:(CDVInvokedUrlCommand*)command;

    
- (void)postAirborne:(CDVInvokedUrlCommand*)command;

    
- (void)postLanded:(CDVInvokedUrlCommand*)command;

    
- (void)postFlightPathCreated:(CDVInvokedUrlCommand*)command;

    
- (void)postFlightPathUploaded:(CDVInvokedUrlCommand*)command;

    
- (void)postFlightPathEdited:(CDVInvokedUrlCommand*)command;

    
- (void)postFlightPathDeleted:(CDVInvokedUrlCommand*)command;

    
- (void)postFlightPathCompleted:(CDVInvokedUrlCommand*)command;

    
- (void)postFirstPersonViewEnabled:(CDVInvokedUrlCommand*)command;

    
- (void)postFirstPersonViewDisabled:(CDVInvokedUrlCommand*)command;

    
- (void)postStartedAerialVideo:(CDVInvokedUrlCommand*)command;

    
- (void)postStartedAerialVideoDetailed:(CDVInvokedUrlCommand*)command;

    
- (void)postStoppedAerialVideo:(CDVInvokedUrlCommand*)command;

    
- (void)postTookAerialPicture:(CDVInvokedUrlCommand*)command;

    
- (void)postStartedAerialTimelapse:(CDVInvokedUrlCommand*)command;

    
- (void)postStoppedAerialTimelapse:(CDVInvokedUrlCommand*)command;

    
- (void)postRequestedReturnToBase:(CDVInvokedUrlCommand*)command;

    
- (void)postSwitchedToHelicopterFlyingMode:(CDVInvokedUrlCommand*)command;

    
- (void)postSwitchedToAltitudeFlyingMode:(CDVInvokedUrlCommand*)command;

    
- (void)postSwitchedToGPSHoldFlyingMode:(CDVInvokedUrlCommand*)command;

    
- (void)postSwitchedToCustomFlyingMode:(CDVInvokedUrlCommand*)command;

    
- (void)postSetMaxAltitude:(CDVInvokedUrlCommand*)command;

    
- (void)postSetAutoReturnInSeconds:(CDVInvokedUrlCommand*)command;

    
- (void)postSetAutoReturnWhenLowMemory:(CDVInvokedUrlCommand*)command;

    
- (void)postSetAutoReturnWhenLowBattery:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeDrone
***/


/***
* Region PyzeWeatherAndForecast
***/
    
- (void)postWeatherRequestedForType:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherHistoricalRequest:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherStationsRequestWithClusterData:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherMapLayersRequested:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherRequestForUVIndexAtPoint:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherResponseForType:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherResponseForHistoricalData:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherStationResponseData:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherMapLayersResponse:(CDVInvokedUrlCommand*)command;

    
- (void)postWeatherResponseForUVIndex:(CDVInvokedUrlCommand*)command;

    
- (void)postForecastRequestForKeywords:(CDVInvokedUrlCommand*)command;

    
- (void)postForecastResponseForKeywordsShort:(CDVInvokedUrlCommand*)command;

    
- (void)postForecastFetch:(CDVInvokedUrlCommand*)command;

    
- (void)postForecastFetchResponse:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeWeatherAndForecast
***/


/***
* Region PyzeSupport
***/

    
- (void)postRequestedPhoneCallback:(CDVInvokedUrlCommand*)command;

    
- (void)postLiveChatStartedWithTopic:(CDVInvokedUrlCommand*)command;

    
- (void)postLiveChatEndedWithTopic:(CDVInvokedUrlCommand*)command;

    
- (void)postTicketCreated:(CDVInvokedUrlCommand*)command;

    
- (void)postFeedbackReceived:(CDVInvokedUrlCommand*)command;

    
- (void)postQualityOfServiceRated:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeSupport
***/


/***
* Region PyzeCommerceSupport
***/
    
- (void)pyzeCommerceSupportPostLiveChatStartedWithTopic:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeCommerceSupportPostLiveChatEndedWithTopic:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeCommerceSupportPostTicketCreated:(CDVInvokedUrlCommand*)command;

    
- (void)pyzeCommerceSupportPostFeedbackReceived:(CDVInvokedUrlCommand*)command;

- (void)pyzeCommerceSupportPostQualityOfServiceRated:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeCommerceSupport
***/

/***
* Region PyzeInAppMessages
***/

- (void)showInAppNotification:(CDVInvokedUrlCommand*)command;

- (void)showInAppNotificationWithCustomAttributes:(CDVInvokedUrlCommand*)command;
    
- (void)closeInAppMessage:(CDVInvokedUrlCommand*)command;
    
- (void)countNewUnFetchedMessages:(CDVInvokedUrlCommand*)command;
    
- (void)getMessageHeaderOfType:(CDVInvokedUrlCommand*)command;
    
- (void)getMessageWithContentID:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeInAppMessages
***/

/***
     Region PyzeIdentity
***/

    
- (void) setUserIdentifier:(CDVInvokedUrlCommand*)command;
    
- (void) resetUserIdentifier:(CDVInvokedUrlCommand*)command;
    
- (void) postTraits  :(CDVInvokedUrlCommand*)command;

/***
     End Region PyzeIdentity
***/


/***
* Region PyzeSceneFlow
***/
    
- (void)postSecondsOnScene:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzeSceneFlow
***/

/***
* Region PyzePersonalizationIntelligence
***/

- (void)getTags:(CDVInvokedUrlCommand*)command;

- (void)isTagSet:(CDVInvokedUrlCommand*)command;
    
- (void)areAnyTagSet:(CDVInvokedUrlCommand*)command;
    
- (void)areAllTagSet:(CDVInvokedUrlCommand*)command;

/***
     * End Region PyzePersonalizationIntelligence
***/

/***
* Region PyzeSMS
***/
- (void)registerDevice:(CDVInvokedUrlCommand*)command;

- (void)sendVerification:(CDVInvokedUrlCommand*)command;

- (void)unsubscribeDevice:(CDVInvokedUrlCommand*)command;

/***
* End Region PyzeSMS
***/
@end
