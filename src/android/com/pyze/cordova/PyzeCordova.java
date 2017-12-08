package com.pyze.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;
import android.app.Activity;

import com.pyze.android.Pyze;
import com.pyze.android.PyzeEvents;
import com.pyze.android.PyzeIdentity;
import com.pyze.android.PyzeSceneFlow;
import com.pyze.android.constants.Constants;
import com.pyze.android.events.dto.PyzeGeoPoint;
import com.pyze.android.inapp.PyzeInAppMessagesManager;
import com.pyze.android.inapp.dto.Button;
import com.pyze.android.inapp.dto.Message;
import com.pyze.android.inapp.dto.Metadata;
import com.pyze.android.inapp.dto.MetadataList;
import com.pyze.android.inapp.templates.ui.InAppNotificationTemplateDialogFragment;
import com.pyze.android.tags.PyzePersonalizationIntelligence;
import com.pyze.android.tags.TagsManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class PyzeCordova extends CordovaPlugin {

    interface PyzeMethodInt{
        public static int POST_CUSTOM_EVENT = 1;
        public static int POST_CUSTOM_EVENT_WITH_ATTRIBUTES = 2;
        public static int POST_TIMED_EVENT_WITH_NAME = 3;
        public static int POST_TIMED_EVENT_WITH_NAME_AND_ATTRIBUTES = 4;
        //PYZE ADVOCACY
        public static int POST_REQUEST_FEEDBACK = 5;
        public static int POST_FEEDBACK_PRVIDED = 6;
        public static int POST_REQUEST_RATING = 7;
        //PYZE AD
        public static int POST_AD_REQUESTED = 8;
        public static int POST_AD_RECEIVED = 9;
        public static int POST_AD_CLICKED = 10;
        //PYZE ACCOUNT
        public static int POST_LOGIN_OFFERED = 11;
        public static int POST_LOGIN_STARTED = 12;
        public static int POST_SOCIAL_LOGIN_OFFERED = 13;
        public static int POST_SOCIAL_LOGIN_STARTED = 14;
        public static int POST_SOCIAL_LOGIN_COMPLETED = 15;
        public static int POST_PASSWORD_REEST_COMPLETED = 16;
        public static int POST_REGISTRATION_OFFERED = 17;
        public static int POST_REGISTRATION_STARTED = 18;
        public static int POST_REGISTRATION_COMPLETED = 19;
        public static int POST_LOGIN_COMPLETED = 20;
        public static int POST_LOGOUT_COMPLETED = 21;
        public static int POST_PASSWORD_RESET_REQUEST = 22;
        //PYZE CONTENT
        public static int POST_VIEWED = 23;
        public static int POST_SEARCHED = 24;
        public static int POST_RATED_ON_5_POINT_SCALE = 25;
        public static int POST_RATED_THUMBS_UP = 26;
        public static int POST_RATED_THUMBS_DOWN = 27;
        //PYZE MESSAGING
        public static int POST_MESSAGE_SENT= 28;
        public static int POST_MESSAGE_SENT_OF_TYPE = 29;
        public static int POST_MESSAGE_RECEIVED = 30;
        public static int POST_MESSAGE_NEW_CONVERSATION = 31;
        public static int POST_MESSAGE_VOICE_CALL = 32;
        //PYZE IN APP PURCHASE REVENUE
        public static int postPriceListViewed = 33;
        public static int postBuyItem = 34;
        public static int postBuyItemShort = 35;
        public static int postBuyItemUSD = 36;
        //Pyze Tasks
        public static int postAddToCalendarWithAttributes = 37;
        //Pyze Social
        public static int postSocialContentShareForNetworkName = 38;
        public static int postLiked = 39;
        public static int postFollowed = 40;
        public static int postSubscribed = 41;
        public static int postInvitedFriends = 42;
        public static int postFoundFriends = 43;
        //Pyze Commerce Discovery
        public static int pyzeCommerceDiscoveryPostSearched = 44;
        public static int postBrowsedCategory = 45;
        public static int postBrowsedDeals = 46;
        public static int postBrowsedRecommendations = 47;
        public static int postBrowsedPrevOrders = 48;
        //Pyze Commerce Curated List
        public static int postCreated = 49;
        public static int postBrowsed = 50;
        public static int postAddedItem = 51;
        public static int postRemovedItem = 52;
        public static int postShared = 53;
        public static int postPublished = 54;
        //Pyze Commerce Wish List
        public static int pyzeCommerceWishListPostCreated = 55;
        public static int pyzeCommerceWishListPostBrowsed = 56;
        public static int pyzeCommerceWishListPostAddedItem = 57;
        public static int pyzeCommerceWishListPostRemovedItem = 58;
        public static int pyzeCommerceWishListPostShared = 59;
        //Pyze Commerce Beacon
        public static int postEnteredRegion = 60;
        public static int postExitedRegion = 61;
        public static int postTransactedRegion = 62;
        //Pyze Commerce Cart
        public static int postAddItem = 63;
        public static int postAddItemFromDeals = 64;
        public static int postAddItemFromWishList = 65;
        public static int postAddItemFromCuratedList = 66;
        public static int postAddItemFromRecommendations = 67;
        public static int postAddItemFromPreviousOrders = 68;
        public static int postAddItemFromSearchResults = 69;
        public static int postAddItemFromSubscriptionList = 70;
        public static int postRemoveItemFromCart = 71;
        public static int postView = 72;
        public static int postShare = 73;
        //Pyze Commerce Item
        public static int postViewedItem = 74;
        public static int postScannedItem = 75;
        public static int postViewedReviews = 76;
        public static int postViewedDetails = 77;
        public static int postViewedPrice = 78;
        public static int postItemShare = 79;
        public static int postItemRateOn5Scale = 80;
        //Pyze Commerce Checkout
        public static int postCheckoutStarted = 81;
        public static int postCheckoutCompleted = 82;
        public static int postCheckoutAbandoned = 83;
        public static int postCheckoutFailed = 84;
        //Pyze Commerce Shipping
        public static int postShippingStarted = 85;
        public static int postShippingCompleted = 86;
        public static int postShippingAbandoned = 87;
        public static int postShippingFailed = 88;
        //PyzeCommerc eBilling
        public static int postBillingStarted = 89;
        public static int postBillingCompleted = 90;
        public static int postBillingAbandoned = 91;
        public static int postBillingFailed = 92;
        //Pyze Commerce Payment
        public static int postPaymentStarted = 93;
        public static int postPaymentCompleted = 94;
        public static int postPaymentAbandoned = 95;
        public static int postPaymentFailed = 96;
        //Pyze Explicit Activation
        public static int postWithAttributes = 97;
        public static int post = 98;
        //Pyze Gaming
        public static int postLevelStarted = 99;
        public static int postLevelEnded = 100;
        public static int postPowerUpConsumed = 101;
        public static int postInGameItemPurchased = 102;
        public static int postAchievementEarned = 103;
        public static int postSummaryViewed = 104;
        public static int postLeaderBoardViewed = 105;
        public static int postScorecardViewed = 106;
        public static int postHelpViewed = 107;
        public static int postTutorialViewed = 108;
        public static int postFriendChallenged = 109;
        public static int postChallengeAccepted = 110;
        public static int postChallengeDeclined = 111;
        public static int postGameStarted = 112;
        public static int postGameEnd = 113;
        //Pyze Health and Fitness
        public static int postStarted = 114;
        public static int postEnded = 115;
        public static int postAchievementReceived = 116;
        public static int postStepGoalCompleted = 117;
        public static int postGoalCompleted = 118;
        public static int postChallengedFriend = 119;
        public static int pyzeHealthAndFitnessPostChallengeAccepted = 120;
        //Pyze Media
        public static int pyzeMediaPostPlayedMedia = 121;
        public static int pyzeMediaPostSearched = 122;
        public static int postRateOn5PointScale = 123;
        public static int pyzeMediaPostRatedThumbsUp = 124;
        public static int pyzeMediaPostRatedThumbsDown = 125;
        //Pyze Bitcoin
        public static int postSentBitCoins = 126;
        public static int postRequestedBitCoins = 127;
        public static int postReceivedBitCoins = 128;
        public static int postImportedPrivateKey = 129;
        public static int postViewedTransaction = 130;
        public static int postScannedPrivateKey = 131;
        //Pyze Commerce Revenue
        public static int postRevenue = 132;
        public static int postRevenueDetailed = 133;
        public static int postRevenueUsingApplePay = 134;
        public static int postRevenueUsingSamsungPay = 135;
        public static int postRevenueUsingGooglePay = 136;
        //Pyze Drone
        public static int postPreflightCheckCompleted = 137;
        public static int postInflightCheckCompleted = 138;
        public static int postConnected = 139;
        public static int postDisconnected = 140;
        public static int postAirborne = 141;
        public static int postLanded = 142;
        public static int postFlightPathCreated = 170;
        public static int postFlightPathUploaded = 143;
        public static int postFlightPathEdited = 144;
        public static int postFlightPathDeleted = 145;
        public static int postFlightPathCompleted = 146;
        public static int postFirstPersonViewEnabled = 147;
        public static int postFirstPersonViewDisabled = 148;
        public static int postStartedAerialVideo = 149;
        public static int postStartedAerialVideoDetailed = 150;
        public static int postStoppedAerialVideo = 151;
        public static int postTookAerialPicture = 152;
        public static int postStartedAerialTimelapse = 153;
        public static int postStoppedAerialTimelapse = 171;
        public static int postRequestedReturnToBase = 155;
        public static int postSwitchedToHelicopterFlyingMode = 156;
        public static int postSwitchedToAltitudeFlyingMode = 157;
        public static int postSwitchedToGPSHoldFlyingMode = 158;
        public static int postSwitchedToCustomFlyingMode = 159;
        public static int postSetMaxAltitude = 160;
        public static int postSetAutoReturnInSeconds = 161;
        public static int postSetAutoReturnWhenLowMemory = 162;
        public static int postSetAutoReturnWhenLowBattery = 163;
        //Pyze Whether and Forecast
        public static int postWeatherRequestedForType = 164;
        public static int postWeatherHistoricalRequest = 165;
        public static int postWeatherStationsRequestWithClusterData = 166;
        public static int postWeatherMapLayersRequested = 167;
        public static int postWeatherRequestForUVIndexAtPoint = 168;
        public static int postWeatherResponseForType = 169;
        public static int postWeatherResponseForHistoricalData = 172;
        public static int postWeatherStationResponseData = 173;
        public static int postWeatherMapLayersResponse = 174;
        public static int postWeatherResponseForUVIndex = 175;
        public static int postForecastRequestForKeywords = 176;
        public static int postForecastResponseForKeywordsShort = 177;
        public static int postForecastFetch = 178;
        public static int postForecastFetchResponse = 179;
        //Pyze Support
        public static int postRequestedPhoneCallback = 180;
        public static int postLiveChatStartedWithTopic = 181;
        public static int postLiveChatEndedWithTopic = 182;
        public static int postTicketCreated = 183;
        public static int postFeedbackReceived = 184;
        public static int postQualityOfServiceRated = 185;
        //Pyze Commerce Support
        public static int pyzeCommerceSupportPostLiveChatStartedWithTopic = 186;
        public static int pyzeCommerceSupportPostLiveChatEndedWithTopic = 187;
        public static int pyzeCommerceSupportPostTicketCreated = 188;
        public static int pyzeCommerceSupportPostFeedbackReceived = 189;
        public static int pyzeCommerceSupportPostQualityOfServiceRated = 190;
        //Pyze In App Message
        public static int showInAppNotification = 191;
        public static int showInAppNotificatonWithCustomAttributes = 192;
        public static int closeInAppMessage = 193;
        public static int countNewUnFetchedMessages = 194;
        public static int getMessageHeaderOfType = 195;
        public static int getMessageWithContentID = 196;
        //Pyze Identity
        public static int setUserIdentifier = 197;
        public static int resetUserIdentifier = 198;
        public static int postTraits = 199;
        //Pyze Scene Flow
        public static int postSecondsOnScene = 200;
        //Pyze Personalization Intelligence
        public static int getTags = 201;
        public static int isTagSet = 202;
        public static int areAnyTagSet = 203;
        public static int areAllTagSet = 204;
    }

    private static final Map<String, Integer> stringMethodToInt;
    static
    {
        stringMethodToInt = new HashMap<String, Integer>();
        stringMethodToInt.put("postCustomEvent", PyzeMethodInt.POST_CUSTOM_EVENT);
        stringMethodToInt.put("postCustomEventWithAttributes", PyzeMethodInt.POST_CUSTOM_EVENT_WITH_ATTRIBUTES);
        stringMethodToInt.put("postTimedEventWithName", PyzeMethodInt.POST_TIMED_EVENT_WITH_NAME);
        stringMethodToInt.put("postTimedEventWithNameAndAttributes", PyzeMethodInt.POST_TIMED_EVENT_WITH_NAME_AND_ATTRIBUTES);

        stringMethodToInt.put("postRequestFeedback", PyzeMethodInt.POST_REQUEST_FEEDBACK);
        stringMethodToInt.put("postFeedbackProvided", PyzeMethodInt.POST_FEEDBACK_PRVIDED);
        stringMethodToInt.put("postRequestRating", PyzeMethodInt.POST_REQUEST_RATING);

        stringMethodToInt.put("postAdRequested", PyzeMethodInt.POST_AD_REQUESTED);
        stringMethodToInt.put("postAdReceived", PyzeMethodInt.POST_AD_RECEIVED);
        stringMethodToInt.put("postAdClicked", PyzeMethodInt.POST_AD_CLICKED);

        stringMethodToInt.put("postLoginOffered", PyzeMethodInt.POST_LOGIN_OFFERED);
        stringMethodToInt.put("postLoginStarted", PyzeMethodInt.POST_LOGIN_STARTED);
        stringMethodToInt.put("postSocialLoginOffered", PyzeMethodInt.POST_SOCIAL_LOGIN_OFFERED);
        stringMethodToInt.put("postSocialLoginStarted", PyzeMethodInt.POST_SOCIAL_LOGIN_STARTED);
        stringMethodToInt.put("postSocialLoginCompleted", PyzeMethodInt.POST_SOCIAL_LOGIN_COMPLETED);
        stringMethodToInt.put("postPasswordResetCompleted", PyzeMethodInt.POST_PASSWORD_REEST_COMPLETED);
        stringMethodToInt.put("postRegistrationOffered", PyzeMethodInt.POST_REGISTRATION_OFFERED);
        stringMethodToInt.put("postRegistrationStarted", PyzeMethodInt.POST_REGISTRATION_STARTED);
        stringMethodToInt.put("postRegistrationCompleted", PyzeMethodInt.POST_REGISTRATION_COMPLETED);
        stringMethodToInt.put("postLoginCompleted", PyzeMethodInt.POST_LOGIN_COMPLETED);
        stringMethodToInt.put("postLogoutCompleted", PyzeMethodInt.POST_LOGOUT_COMPLETED);
        stringMethodToInt.put("postPasswordResetRequest", PyzeMethodInt.POST_PASSWORD_RESET_REQUEST);

        stringMethodToInt.put("postViewed", PyzeMethodInt.POST_VIEWED);
        stringMethodToInt.put("postSearched", PyzeMethodInt.POST_SEARCHED);
        stringMethodToInt.put("postRatedOn5PointScale", PyzeMethodInt.POST_RATED_ON_5_POINT_SCALE);
        stringMethodToInt.put("postRatedThumbsUp", PyzeMethodInt.POST_RATED_THUMBS_UP);
        stringMethodToInt.put("postRatedThumbsDown", PyzeMethodInt.POST_RATED_THUMBS_DOWN);

        stringMethodToInt.put("postMessageSent", PyzeMethodInt.POST_MESSAGE_SENT);
        stringMethodToInt.put("postMessageSentOfType", PyzeMethodInt.POST_MESSAGE_SENT_OF_TYPE);
        stringMethodToInt.put("postMessageReceived", PyzeMethodInt.POST_MESSAGE_RECEIVED);
        stringMethodToInt.put("postMessageNewConversation", PyzeMethodInt.POST_MESSAGE_NEW_CONVERSATION);
        stringMethodToInt.put("postMessageVoiceCall", PyzeMethodInt.POST_MESSAGE_VOICE_CALL);

        stringMethodToInt.put("postPriceListViewed", PyzeMethodInt.postPriceListViewed);
        stringMethodToInt.put("postBuyItem", PyzeMethodInt.postBuyItem);
        stringMethodToInt.put("postBuyItemShort", PyzeMethodInt.postBuyItemShort);
        stringMethodToInt.put("postBuyItemUSD", PyzeMethodInt.postBuyItemUSD);

        stringMethodToInt.put("postAddToCalendarWithAttributes", PyzeMethodInt.postAddToCalendarWithAttributes);

        stringMethodToInt.put("postSocialContentShareForNetworkName", PyzeMethodInt.postSocialContentShareForNetworkName);
        stringMethodToInt.put("postLiked", PyzeMethodInt.postLiked);
        stringMethodToInt.put("postFollowed", PyzeMethodInt.postFollowed);
        stringMethodToInt.put("postSubscribed", PyzeMethodInt.postSubscribed);
        stringMethodToInt.put("postInvitedFriends", PyzeMethodInt.postInvitedFriends);
        stringMethodToInt.put("postFoundFriends", PyzeMethodInt.postFoundFriends);

        stringMethodToInt.put("pyzeCommerceDiscoveryPostSearched", PyzeMethodInt.pyzeCommerceDiscoveryPostSearched);
        stringMethodToInt.put("postBrowsedCategory", PyzeMethodInt.postBrowsedCategory);
        stringMethodToInt.put("postBrowsedDeals", PyzeMethodInt.postBrowsedDeals);
        stringMethodToInt.put("postBrowsedRecommendations", PyzeMethodInt.postBrowsedRecommendations);
        stringMethodToInt.put("postBrowsedPrevOrders", PyzeMethodInt.postBrowsedPrevOrders);
        
        stringMethodToInt.put("postCreated", PyzeMethodInt.postCreated);
        stringMethodToInt.put("postBrowsed", PyzeMethodInt.postBrowsed);
        stringMethodToInt.put("postAddedItem", PyzeMethodInt.postAddedItem);
        stringMethodToInt.put("postRemovedItem", PyzeMethodInt.postRemovedItem);
        stringMethodToInt.put("postShared", PyzeMethodInt.postShared);
        stringMethodToInt.put("postPublished", PyzeMethodInt.postPublished);

        stringMethodToInt.put("pyzeCommerceWishListPostCreated", PyzeMethodInt.pyzeCommerceWishListPostCreated);
        stringMethodToInt.put("pyzeCommerceWishListPostBrowsed", PyzeMethodInt.pyzeCommerceWishListPostBrowsed);
        stringMethodToInt.put("pyzeCommerceWishListPostAddedItem", PyzeMethodInt.pyzeCommerceWishListPostAddedItem);
        stringMethodToInt.put("pyzeCommerceWishListPostRemovedItem", PyzeMethodInt.pyzeCommerceWishListPostRemovedItem);
        stringMethodToInt.put("pyzeCommerceWishListPostShared", PyzeMethodInt.pyzeCommerceWishListPostShared);

        stringMethodToInt.put("postEnteredRegion", PyzeMethodInt.postEnteredRegion);
        stringMethodToInt.put("postExitedRegion", PyzeMethodInt.postExitedRegion);
        stringMethodToInt.put("postTransactedRegion", PyzeMethodInt.postTransactedRegion);

        stringMethodToInt.put("postAddItem", PyzeMethodInt.postAddItem);
        stringMethodToInt.put("postAddItemFromDeals", PyzeMethodInt.postAddItemFromDeals);
        stringMethodToInt.put("postAddItemFromWishList", PyzeMethodInt.postAddItemFromWishList);
        stringMethodToInt.put("postAddItemFromCuratedList", PyzeMethodInt.postAddItemFromCuratedList);
        stringMethodToInt.put("postAddItemFromRecommendations", PyzeMethodInt.postAddItemFromRecommendations);
        stringMethodToInt.put("postAddItemFromPreviousOrders", PyzeMethodInt.postAddItemFromPreviousOrders);
        stringMethodToInt.put("postAddItemFromSearchResults", PyzeMethodInt.postAddItemFromSearchResults);
        stringMethodToInt.put("postAddItemFromSubscriptionList", PyzeMethodInt.postAddItemFromSubscriptionList);
        stringMethodToInt.put("postRemoveItemFromCart", PyzeMethodInt.postRemoveItemFromCart);
        stringMethodToInt.put("postView", PyzeMethodInt.postView);
        stringMethodToInt.put("postShare", PyzeMethodInt.postShare);

        stringMethodToInt.put("postViewedItem", PyzeMethodInt.postViewedItem);
        stringMethodToInt.put("postScannedItem", PyzeMethodInt.postScannedItem);
        stringMethodToInt.put("postViewedReviews", PyzeMethodInt.postViewedReviews);
        stringMethodToInt.put("postViewedDetails", PyzeMethodInt.postViewedDetails);
        stringMethodToInt.put("postViewedPrice", PyzeMethodInt.postViewedPrice);
        stringMethodToInt.put("postItemShare", PyzeMethodInt.postItemShare);
        stringMethodToInt.put("postItemRateOn5Scale", PyzeMethodInt.postItemRateOn5Scale);

        stringMethodToInt.put("postCheckoutStarted", PyzeMethodInt.postCheckoutStarted);
        stringMethodToInt.put("postCheckoutCompleted", PyzeMethodInt.postCheckoutCompleted);
        stringMethodToInt.put("postCheckoutAbandoned", PyzeMethodInt.postCheckoutAbandoned);
        stringMethodToInt.put("postCheckoutFailed", PyzeMethodInt.postCheckoutFailed);

        stringMethodToInt.put("postShippingStarted", PyzeMethodInt.postShippingStarted);
        stringMethodToInt.put("postShippingCompleted", PyzeMethodInt.postShippingCompleted);
        stringMethodToInt.put("postShippingAbandoned", PyzeMethodInt.postShippingAbandoned);
        stringMethodToInt.put("postShippingFailed", PyzeMethodInt.postShippingFailed);

        stringMethodToInt.put("postBillingStarted", PyzeMethodInt.postBillingStarted);
        stringMethodToInt.put("postBillingCompleted", PyzeMethodInt.postBillingCompleted);
        stringMethodToInt.put("postBillingAbandoned", PyzeMethodInt.postBillingAbandoned);
        stringMethodToInt.put("postBillingFailed", PyzeMethodInt.postBillingFailed);
        
        stringMethodToInt.put("postPaymentStarted", PyzeMethodInt.postPaymentStarted);
        stringMethodToInt.put("postPaymentCompleted", PyzeMethodInt.postPaymentCompleted);
        stringMethodToInt.put("postPaymentAbandoned", PyzeMethodInt.postPaymentAbandoned);
        stringMethodToInt.put("postPaymentFailed", PyzeMethodInt.postPaymentFailed);

        stringMethodToInt.put("postWithAttributes", PyzeMethodInt.postWithAttributes);
        stringMethodToInt.put("post", PyzeMethodInt.post);

        stringMethodToInt.put("postLevelStarted", PyzeMethodInt.postLevelStarted);
        stringMethodToInt.put("postLevelEnded", PyzeMethodInt.postLevelEnded);
        stringMethodToInt.put("postPowerUpConsumed", PyzeMethodInt.postPowerUpConsumed);
        stringMethodToInt.put("postInGameItemPurchased", PyzeMethodInt.postInGameItemPurchased);
        stringMethodToInt.put("postAchievementEarned", PyzeMethodInt.postAchievementEarned);
        stringMethodToInt.put("postSummaryViewed", PyzeMethodInt.postSummaryViewed);
        stringMethodToInt.put("postLeaderBoardViewed", PyzeMethodInt.postLeaderBoardViewed);
        stringMethodToInt.put("postScorecardViewed", PyzeMethodInt.postScorecardViewed);
        stringMethodToInt.put("postHelpViewed", PyzeMethodInt.postHelpViewed);
        stringMethodToInt.put("postTutorialViewed", PyzeMethodInt.postTutorialViewed);
        stringMethodToInt.put("postFriendChallenged", PyzeMethodInt.postFriendChallenged);
        stringMethodToInt.put("postChallengeAccepted", PyzeMethodInt.postChallengeAccepted);
        stringMethodToInt.put("postChallengeDeclined", PyzeMethodInt.postChallengeDeclined);
        stringMethodToInt.put("postGameStarted", PyzeMethodInt.postGameStarted);
        stringMethodToInt.put("postGameEnd", PyzeMethodInt.postGameEnd);

        stringMethodToInt.put("postStarted", PyzeMethodInt.postStarted);
        stringMethodToInt.put("postEnded", PyzeMethodInt.postEnded);
        stringMethodToInt.put("postAchievementReceived", PyzeMethodInt.postAchievementReceived);
        stringMethodToInt.put("postStepGoalCompleted", PyzeMethodInt.postStepGoalCompleted);
        stringMethodToInt.put("postGoalCompleted", PyzeMethodInt.postGoalCompleted);
        stringMethodToInt.put("postChallengedFriend", PyzeMethodInt.postChallengedFriend);
        stringMethodToInt.put("pyzeHealthAndFitnessPostChallengeAccepted", PyzeMethodInt.pyzeHealthAndFitnessPostChallengeAccepted);

        stringMethodToInt.put("pyzeMediaPostPlayedMedia", PyzeMethodInt.pyzeMediaPostPlayedMedia);
        stringMethodToInt.put("pyzeMediaPostSearched", PyzeMethodInt.pyzeMediaPostSearched);
        stringMethodToInt.put("postRateOn5PointScale", PyzeMethodInt.postRateOn5PointScale);
        stringMethodToInt.put("pyzeMediaPostRatedThumbsUp", PyzeMethodInt.pyzeMediaPostRatedThumbsUp);
        stringMethodToInt.put("pyzeMediaPostRatedThumbsDown", PyzeMethodInt.pyzeMediaPostRatedThumbsDown);

        stringMethodToInt.put("postSentBitCoins", PyzeMethodInt.postSentBitCoins);
        stringMethodToInt.put("postRequestedBitCoins", PyzeMethodInt.postRequestedBitCoins);
        stringMethodToInt.put("postReceivedBitCoins", PyzeMethodInt.postReceivedBitCoins);
        stringMethodToInt.put("postImportedPrivateKey", PyzeMethodInt.postImportedPrivateKey);
        stringMethodToInt.put("postViewedTransaction", PyzeMethodInt.postViewedTransaction);
        stringMethodToInt.put("postScannedPrivateKey", PyzeMethodInt.postScannedPrivateKey);

        stringMethodToInt.put("postRevenue", PyzeMethodInt.postRevenue);
        stringMethodToInt.put("postRevenueDetailed", PyzeMethodInt.postRevenueDetailed);
        stringMethodToInt.put("postRevenueUsingApplePay", PyzeMethodInt.postRevenueUsingApplePay);
        stringMethodToInt.put("postRevenueUsingSamsungPay", PyzeMethodInt.postRevenueUsingSamsungPay);
        stringMethodToInt.put("postRevenueUsingGooglePay", PyzeMethodInt.postRevenueUsingGooglePay);
        
        stringMethodToInt.put("postPreflightCheckCompleted", PyzeMethodInt.postPreflightCheckCompleted);
        stringMethodToInt.put("postInflightCheckCompleted", PyzeMethodInt.postInflightCheckCompleted);
        stringMethodToInt.put("postConnected", PyzeMethodInt.postConnected);
        stringMethodToInt.put("postDisconnected", PyzeMethodInt.postDisconnected);
        stringMethodToInt.put("postAirborne", PyzeMethodInt.postAirborne);
        stringMethodToInt.put("postLanded", PyzeMethodInt.postLanded);
        stringMethodToInt.put("postFlightPathCreated", PyzeMethodInt.postFlightPathCreated);
        stringMethodToInt.put("postFlightPathUploaded", PyzeMethodInt.postFlightPathUploaded);
        stringMethodToInt.put("postFlightPathEdited", PyzeMethodInt.postFlightPathEdited);
        stringMethodToInt.put("postFlightPathDeleted", PyzeMethodInt.postFlightPathDeleted);
        stringMethodToInt.put("postFlightPathCompleted", PyzeMethodInt.postFlightPathCompleted);
        stringMethodToInt.put("postFirstPersonViewEnabled", PyzeMethodInt.postFirstPersonViewEnabled);
        stringMethodToInt.put("postFirstPersonViewDisabled", PyzeMethodInt.postFirstPersonViewDisabled);
        stringMethodToInt.put("postStartedAerialVideo", PyzeMethodInt.postStartedAerialVideo);
        stringMethodToInt.put("postStartedAerialVideoDetailed", PyzeMethodInt.postStartedAerialVideoDetailed);
        stringMethodToInt.put("postStoppedAerialVideo", PyzeMethodInt.postStoppedAerialVideo);
        stringMethodToInt.put("postTookAerialPicture", PyzeMethodInt.postTookAerialPicture);
        stringMethodToInt.put("postStartedAerialTimelapse", PyzeMethodInt.postStartedAerialTimelapse);
        stringMethodToInt.put("postStoppedAerialTimelapse", PyzeMethodInt.postStoppedAerialTimelapse);
        stringMethodToInt.put("postRequestedReturnToBase", PyzeMethodInt.postRequestedReturnToBase);
        stringMethodToInt.put("postSwitchedToHelicopterFlyingMode", PyzeMethodInt.postSwitchedToHelicopterFlyingMode);
        stringMethodToInt.put("postSwitchedToAltitudeFlyingMode", PyzeMethodInt.postSwitchedToAltitudeFlyingMode);
        stringMethodToInt.put("postSwitchedToGPSHoldFlyingMode", PyzeMethodInt.postSwitchedToGPSHoldFlyingMode);
        stringMethodToInt.put("postSwitchedToCustomFlyingMode", PyzeMethodInt.postSwitchedToCustomFlyingMode);
        stringMethodToInt.put("postSetMaxAltitude", PyzeMethodInt.postSetMaxAltitude);
        stringMethodToInt.put("postSetAutoReturnInSeconds", PyzeMethodInt.postSetAutoReturnInSeconds);
        stringMethodToInt.put("postSetAutoReturnWhenLowMemory", PyzeMethodInt.postSetAutoReturnWhenLowMemory);
        stringMethodToInt.put("postSetAutoReturnWhenLowBattery", PyzeMethodInt.postSetAutoReturnWhenLowBattery);

        stringMethodToInt.put("postWeatherRequestedForType", PyzeMethodInt.postWeatherRequestedForType);
        stringMethodToInt.put("postWeatherHistoricalRequest", PyzeMethodInt.postWeatherHistoricalRequest);
        stringMethodToInt.put("postWeatherStationsRequestWithClusterData", PyzeMethodInt.postWeatherStationsRequestWithClusterData);
        stringMethodToInt.put("postWeatherMapLayersRequested", PyzeMethodInt.postWeatherMapLayersRequested);
        stringMethodToInt.put("postWeatherRequestForUVIndexAtPoint", PyzeMethodInt.postWeatherRequestForUVIndexAtPoint);
        stringMethodToInt.put("postWeatherResponseForType", PyzeMethodInt.postWeatherResponseForType);
        stringMethodToInt.put("postWeatherResponseForHistoricalData", PyzeMethodInt.postWeatherResponseForHistoricalData);
        stringMethodToInt.put("postWeatherStationResponseData", PyzeMethodInt.postWeatherStationResponseData);
        stringMethodToInt.put("postWeatherMapLayersResponse", PyzeMethodInt.postWeatherMapLayersResponse);
        stringMethodToInt.put("postWeatherResponseForUVIndex", PyzeMethodInt.postWeatherResponseForUVIndex);
        stringMethodToInt.put("postForecastRequestForKeywords", PyzeMethodInt.postForecastRequestForKeywords);
        stringMethodToInt.put("postForecastResponseForKeywordsShort", PyzeMethodInt.postForecastResponseForKeywordsShort);
        stringMethodToInt.put("postForecastFetch", PyzeMethodInt.postForecastFetch);
        stringMethodToInt.put("postForecastFetchResponse", PyzeMethodInt.postForecastFetchResponse);

        stringMethodToInt.put("postRequestedPhoneCallback", PyzeMethodInt.postRequestedPhoneCallback);
        stringMethodToInt.put("postLiveChatStartedWithTopic", PyzeMethodInt.postLiveChatStartedWithTopic);
        stringMethodToInt.put("postLiveChatEndedWithTopic", PyzeMethodInt.postLiveChatEndedWithTopic);
        stringMethodToInt.put("postTicketCreated", PyzeMethodInt.postTicketCreated);
        stringMethodToInt.put("postFeedbackReceived", PyzeMethodInt.postFeedbackReceived);
        stringMethodToInt.put("postQualityOfServiceRated", PyzeMethodInt.postQualityOfServiceRated);

        stringMethodToInt.put("pyzeCommerceSupportPostLiveChatStartedWithTopic", PyzeMethodInt.pyzeCommerceSupportPostLiveChatStartedWithTopic);
        stringMethodToInt.put("pyzeCommerceSupportPostLiveChatEndedWithTopic", PyzeMethodInt.pyzeCommerceSupportPostLiveChatEndedWithTopic);
        stringMethodToInt.put("pyzeCommerceSupportPostTicketCreated", PyzeMethodInt.pyzeCommerceSupportPostTicketCreated);
        stringMethodToInt.put("pyzeCommerceSupportPostFeedbackReceived", PyzeMethodInt.pyzeCommerceSupportPostFeedbackReceived);
        stringMethodToInt.put("pyzeCommerceSupportPostQualityOfServiceRated", PyzeMethodInt.pyzeCommerceSupportPostQualityOfServiceRated);

        stringMethodToInt.put("showInAppNotification", PyzeMethodInt.showInAppNotification);
        stringMethodToInt.put("showInAppNotificatonWithCustomAttributes", PyzeMethodInt.showInAppNotificatonWithCustomAttributes);
        stringMethodToInt.put("closeInAppMessage", PyzeMethodInt.closeInAppMessage);
        stringMethodToInt.put("countNewUnFetchedMessages", PyzeMethodInt.countNewUnFetchedMessages);
        stringMethodToInt.put("getMessageHeaderOfType", PyzeMethodInt.getMessageHeaderOfType);
        stringMethodToInt.put("getMessageWithContentID", PyzeMethodInt.getMessageWithContentID);

        stringMethodToInt.put("setUserIdentifier", PyzeMethodInt.setUserIdentifier);
        stringMethodToInt.put("resetUserIdentifier", PyzeMethodInt.resetUserIdentifier);
        stringMethodToInt.put("postTraits", PyzeMethodInt.postTraits);

        stringMethodToInt.put("postSecondsOnScene", PyzeMethodInt.postSecondsOnScene);

        stringMethodToInt.put("getTags", PyzeMethodInt.getTags);
        stringMethodToInt.put("isTagSet", PyzeMethodInt.isTagSet);
        stringMethodToInt.put("areAnyTagSet", PyzeMethodInt.areAnyTagSet);
        stringMethodToInt.put("areAllTagSet", PyzeMethodInt.areAllTagSet);
    }


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Pyze.initialize(cordova.getActivity().getApplication());
    }

    @Override
    public boolean execute(
        String action,
        JSONArray args,
        CallbackContext callbackContext
    ) throws JSONException {
        Integer key = stringMethodToInt.get(action);
        if(key != null){
            switch(key.intValue()){
                case PyzeMethodInt.POST_CUSTOM_EVENT :
                    postCustomEvent(args.getString(0));
                break;                
                case PyzeMethodInt.POST_CUSTOM_EVENT_WITH_ATTRIBUTES :
                    postCustomEventWithAttributes(args.getString(0),args.getString(1));
                break;                
                case PyzeMethodInt.POST_TIMED_EVENT_WITH_NAME :
                    postTimedEventWithName(args.getString(0), args.getDouble(1));
                break;                
                case PyzeMethodInt.POST_TIMED_EVENT_WITH_NAME_AND_ATTRIBUTES :
                    postTimedEventWithNameAndAttributes(args.getString(0), args.getDouble(1), args.getString(2));
                break;                
                case PyzeMethodInt.POST_REQUEST_FEEDBACK :
                    postRequestFeedback(args.getString(0));
                break;                
                case PyzeMethodInt.POST_FEEDBACK_PRVIDED :
                    postFeedbackProvided(args.getString(0));
                break;                
                case PyzeMethodInt.POST_REQUEST_RATING :
                    postRequestRating(args.getString(0));
                break;                
                case PyzeMethodInt.POST_AD_REQUESTED :
                    postAdRequested(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.POST_AD_RECEIVED :
                    postAdReceived(args.getString(0), args.getString(1), args.getString(2), args.getBoolean(3), args.getString(4));
                break;                
                case PyzeMethodInt.POST_AD_CLICKED :
                    postAdClicked(args.getString(0), args.getString(1), args.getString(2), args.getBoolean(3), args.getString(4), args.getString(5));
                break;
                case PyzeMethodInt.POST_LOGIN_OFFERED :
                    postLoginOffered(args.getString(0));
                break;              
                case PyzeMethodInt.POST_LOGIN_STARTED :
                    postLoginStarted(args.getString(0));
                break;                
                case PyzeMethodInt.POST_SOCIAL_LOGIN_OFFERED :
                    postSocialLoginOffered(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.POST_SOCIAL_LOGIN_STARTED :
                    postSocialLoginStarted(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.POST_SOCIAL_LOGIN_COMPLETED :
                    postSocialLoginCompleted(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.POST_PASSWORD_REEST_COMPLETED :
                    postPasswordResetCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.POST_REGISTRATION_OFFERED :
                    postRegistrationOffered(args.getString(0));
                break;                
                case PyzeMethodInt.POST_REGISTRATION_STARTED :
                    postRegistrationStarted(args.getString(0));
                break;                
                case PyzeMethodInt.POST_REGISTRATION_COMPLETED :
                    postRegistrationCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.POST_LOGIN_COMPLETED :
                    postLoginCompleted(args.getBoolean(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.POST_LOGOUT_COMPLETED :
                    postLogoutCompleted(args.getString(0));
                break;
                case PyzeMethodInt.POST_PASSWORD_RESET_REQUEST :
                    postPasswordResetRequest(args.getString(0));
                break;
                
                case PyzeMethodInt.POST_VIEWED :
                    postViewed(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.POST_SEARCHED :
                    postSearched(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.POST_RATED_ON_5_POINT_SCALE :
                    postRatedOn5PointScale(args.getString(0), args.getString(1), args.getString(2), args.getInt(3), args.getString(4));
                break;                
                case PyzeMethodInt.POST_RATED_THUMBS_UP :
                    postRatedThumbsUp(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.POST_RATED_THUMBS_DOWN :
                    postRatedThumbsDown(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;

                case PyzeMethodInt.POST_MESSAGE_SENT :
                    postMessageSent(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.POST_MESSAGE_SENT_OF_TYPE :
                    postMessageSentOfType(args.getInt(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.POST_MESSAGE_RECEIVED :
                    postMessageReceived(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.POST_MESSAGE_NEW_CONVERSATION :
                    postMessageNewConversation(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.POST_MESSAGE_VOICE_CALL :
                    postMessageVoiceCall(args.getString(0), args.getString(1));
                break;


                case PyzeMethodInt.postPriceListViewed :
                    postPriceListViewed(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postBuyItem :
                    postBuyItem(args.getString(0), args.getString(1), (float)args.getDouble(2), args.getString(3), args.getString(4), args.getString(5), args.getString(6), args.getBoolean(7), args.getString(8), args.getString(9));
                break;                
                case PyzeMethodInt.postBuyItemShort :
                    postBuyItemShort(args.getString(0), (float) args.getDouble(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postBuyItemUSD :
                    postBuyItemUSD(args.getString(0), (float) args.getDouble(1), args.getString(2));
                break;

                case PyzeMethodInt.postAddToCalendarWithAttributes :
                    postAddToCalendarWithAttributes(args.getString(0));
                break;


                case PyzeMethodInt.postSocialContentShareForNetworkName :
                    postSocialContentShareForNetworkName(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postLiked :
                    postLiked(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postFollowed :
                    postFollowed(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postSubscribed :
                    postSubscribed(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postInvitedFriends :
                    postInvitedFriends(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFoundFriends :
                    postFoundFriends(args.getString(0), args.getString(1));
                break;
                

                case PyzeMethodInt.pyzeCommerceDiscoveryPostSearched :
                    pyzeCommerceDiscoveryPostSearched(args.getString(0), args.getInt(1), args.getString(2));
                break;                
                case PyzeMethodInt.postBrowsedCategory :
                    postBrowsedCategory(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postBrowsedDeals :
                    postBrowsedDeals(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postBrowsedRecommendations :
                    postBrowsedRecommendations(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postBrowsedPrevOrders :
                    postBrowsedPrevOrders(args.getString(0), args.getString(1), args.getString(1));
                break;
                


                case PyzeMethodInt.postCreated :
                    postCreated(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postBrowsed :
                    postBrowsed(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postAddedItem :
                    postAddedItem(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postRemovedItem :
                    postRemovedItem(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postShared :
                    postShared(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postPublished :
                    postPublished(args.getString(0), args.getString(1), args.getString(2));
                break;


                case PyzeMethodInt.pyzeCommerceWishListPostCreated :
                    pyzeCommerceWishListPostCreated(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.pyzeCommerceWishListPostBrowsed :
                    pyzeCommerceWishListPostBrowsed(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.pyzeCommerceWishListPostAddedItem :
                    pyzeCommerceWishListPostAddedItem(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.pyzeCommerceWishListPostRemovedItem :
                    pyzeCommerceWishListPostRemovedItem(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.pyzeCommerceWishListPostShared :
                    pyzeCommerceWishListPostShared(args.getString(0), args.getString(1));
                break;


                case PyzeMethodInt.postEnteredRegion :
                    postEnteredRegion(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postExitedRegion :
                    postExitedRegion(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postTransactedRegion :
                    postTransactedRegion(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4), args.getString(5), args.getString(6));
                break;

                case PyzeMethodInt.postAddItem :
                    postAddItem(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postAddItemFromDeals :
                    postAddItemFromDeals(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postAddItemFromWishList :
                    postAddItemFromWishList(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postAddItemFromCuratedList :
                    postAddItemFromCuratedList(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postAddItemFromRecommendations :
                postAddItemFromRecommendations(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postAddItemFromPreviousOrders :
                    postAddItemFromPreviousOrders(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postAddItemFromSearchResults :
                    postAddItemFromSearchResults(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postAddItemFromSubscriptionList :
                    postAddItemFromSubscriptionList(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4));
                break;                
                case PyzeMethodInt.postRemoveItemFromCart :
                    postRemoveItemFromCart(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postView :
                    postView(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postShare :
                    postShare(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;


                case PyzeMethodInt.postViewedItem :
                    postViewedItem(args.getString(0));
                break;                
                case PyzeMethodInt.postScannedItem :
                    postScannedItem(args.getString(0));
                break;                
                case PyzeMethodInt.postViewedReviews :
                    postViewedReviews(args.getString(0));
                break;                
                case PyzeMethodInt.postViewedDetails :
                    postViewedDetails(args.getString(0));
                break;                
                case PyzeMethodInt.postViewedPrice :
                    postViewedPrice(args.getString(0));
                break;                
                case PyzeMethodInt.postItemShare :
                    postItemShare(args.getString(0));
                break;                
                case PyzeMethodInt.postItemRateOn5Scale :
                    postItemRateOn5Scale(args.getString(0), args.getString(1), args.getString(2));
                break;


                case PyzeMethodInt.postCheckoutStarted :
                    postCheckoutStarted(args.getString(0));
                break;                
                case PyzeMethodInt.postCheckoutCompleted :
                    postCheckoutCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.postCheckoutAbandoned :
                    postCheckoutAbandoned(args.getString(0));
                break;                
                case PyzeMethodInt.postCheckoutFailed :
                    postCheckoutFailed(args.getString(0));
                break;


                case PyzeMethodInt.postShippingStarted :
                    postShippingStarted(args.getString(0));
                break;                
                case PyzeMethodInt.postShippingCompleted :
                    postShippingCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.postShippingAbandoned :
                    postShippingAbandoned(args.getString(0));
                break;                
                case PyzeMethodInt.postShippingFailed :
                    postShippingFailed(args.getString(0));
                break;


                case PyzeMethodInt.postBillingStarted :
                    postBillingStarted(args.getString(0));
                break;                
                case PyzeMethodInt.postBillingCompleted :
                    postBillingCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.postBillingAbandoned :
                    postBillingAbandoned(args.getString(0));
                break;                
                case PyzeMethodInt.postBillingFailed :
                    postBillingFailed(args.getString(0));
                break;


                case PyzeMethodInt.postPaymentStarted :
                    postPaymentStarted(args.getString(0));
                break;                
                case PyzeMethodInt.postPaymentCompleted :
                    postPaymentCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.postPaymentAbandoned :
                    postPaymentAbandoned(args.getString(0));
                break;                
                case PyzeMethodInt.postPaymentFailed :
                    postPaymentFailed(args.getString(0));
                break;


                case PyzeMethodInt.postWithAttributes :
                    postWithAttributes(args.getString(0));
                break;                
                case PyzeMethodInt.post :
                    post();
                break;



                case PyzeMethodInt.postLevelStarted :
                    postLevelStarted(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postLevelEnded :
                    postLevelEnded(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postPowerUpConsumed :
                    postPowerUpConsumed(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postInGameItemPurchased :
                    postInGameItemPurchased(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.postAchievementEarned :
                    postAchievementEarned(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postSummaryViewed :
                    postSummaryViewed(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postLeaderBoardViewed :
                    postLeaderBoardViewed(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postScorecardViewed :
                    postScorecardViewed(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postHelpViewed :
                    postHelpViewed(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postTutorialViewed :
                    postTutorialViewed(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFriendChallenged :
                    postFriendChallenged(args.getString(0));
                break;                
                case PyzeMethodInt.postChallengeAccepted :
                    postChallengeAccepted(args.getString(0));
                break;                
                case PyzeMethodInt.postChallengeDeclined :
                    postChallengeDeclined(args.getString(0));
                break;                
                case PyzeMethodInt.postGameStarted :
                    postGameStarted(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postGameEnd :
                    postGameEnd(args.getString(0), args.getString(1), args.getString(2));
                break;



                case PyzeMethodInt.postStarted :
                    postStarted(args.getString(0));
                break;                
                case PyzeMethodInt.postEnded :
                    postEnded(args.getString(0));
                break;                
                case PyzeMethodInt.postAchievementReceived :
                    postAchievementReceived(args.getString(0));
                break;                
                case PyzeMethodInt.postStepGoalCompleted :
                    postStepGoalCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.postGoalCompleted :
                    postGoalCompleted(args.getString(0));
                break;                
                case PyzeMethodInt.postChallengedFriend :
                    postChallengedFriend(args.getString(0));
                break;                
                case PyzeMethodInt.pyzeHealthAndFitnessPostChallengeAccepted :
                    pyzeHealthAndFitnessPostChallengeAccepted(args.getString(0));
                break;


                case PyzeMethodInt.pyzeMediaPostPlayedMedia :
                    pyzeMediaPostPlayedMedia(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4), args.getString(5));
                break;                
                case PyzeMethodInt.pyzeMediaPostSearched :
                    pyzeMediaPostSearched(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postRateOn5PointScale :
                    postRateOn5PointScale(args.getString(0), args.getString(1), args.getString(2), args.getInt(3), args.getString(4));
                break;                
                case PyzeMethodInt.pyzeMediaPostRatedThumbsUp :
                    pyzeMediaPostRatedThumbsUp(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.pyzeMediaPostRatedThumbsDown :
                    pyzeMediaPostRatedThumbsDown(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;


                case PyzeMethodInt.postSentBitCoins :
                    postSentBitCoins(args.getString(0));
                break;                
                case PyzeMethodInt.postRequestedBitCoins :
                    postRequestedBitCoins(args.getString(0));
                break;                
                case PyzeMethodInt.postReceivedBitCoins :
                    postReceivedBitCoins(args.getString(0));
                break;                
                case PyzeMethodInt.postImportedPrivateKey :
                    postImportedPrivateKey(args.getString(0));
                break;                
                case PyzeMethodInt.postViewedTransaction :
                    postViewedTransaction(args.getString(0));
                break;                
                case PyzeMethodInt.postScannedPrivateKey :
                    postScannedPrivateKey(args.getString(0));
                break;
                

                case PyzeMethodInt.postRevenue :
                    postRevenue(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postRevenueDetailed :
                    postRevenueDetailed(args.getInt(0), args.getString(0), args.getString(0));
                break;                
                case PyzeMethodInt.postRevenueUsingApplePay :
                    postRevenueUsingApplePay(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postRevenueUsingSamsungPay :
                    postRevenueUsingSamsungPay(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postRevenueUsingGooglePay :
                    postRevenueUsingGooglePay(args.getInt(0), args.getString(1));
                break;


                case PyzeMethodInt.postPreflightCheckCompleted :
                    postPreflightCheckCompleted(args.getString(0), args.getString(1), args.getInt(2), args.getInt(3), args.getString(4), args.getString(5), args.getString(6));
                break;                
                case PyzeMethodInt.postInflightCheckCompleted :
                    postInflightCheckCompleted(args.getString(0), args.getString(1), args.getString(2), args.getString(3), args.getString(4), args.getString(5), args.getString(6));
                break;                
                case PyzeMethodInt.postConnected :
                    postConnected(args.getString(0));
                break;                
                case PyzeMethodInt.postDisconnected :
                    postDisconnected(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postAirborne :
                    postAirborne(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postLanded :
                    postLanded(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFlightPathCreated :
                    postFlightPathCreated(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFlightPathUploaded :
                    postFlightPathUploaded(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFlightPathEdited :
                    postFlightPathEdited(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFlightPathDeleted :
                    postFlightPathDeleted(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFlightPathCompleted :
                    postFlightPathCompleted(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFirstPersonViewEnabled :
                    postFirstPersonViewEnabled(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postFirstPersonViewDisabled :
                    postFirstPersonViewDisabled(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postStartedAerialVideo :
                    postStartedAerialVideo(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postStartedAerialVideoDetailed :
                    postStartedAerialVideoDetailed(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postStoppedAerialVideo :
                    postStoppedAerialVideo(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postTookAerialPicture :
                    postTookAerialPicture(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postStartedAerialTimelapse :
                    postStartedAerialTimelapse(args.getString(0), args.getInt(1), args.getInt(2), args.getString(3));
                break;                
                case PyzeMethodInt.postStoppedAerialTimelapse :
                    postStoppedAerialTimelapse(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postRequestedReturnToBase :
                    postRequestedReturnToBase(args.getString(0));
                break;                
                case PyzeMethodInt.postSwitchedToHelicopterFlyingMode :
                    postSwitchedToHelicopterFlyingMode(args.getString(0));
                break;                
                case PyzeMethodInt.postSwitchedToAltitudeFlyingMode :
                    postSwitchedToAltitudeFlyingMode(args.getString(0));
                break;                
                case PyzeMethodInt.postSwitchedToGPSHoldFlyingMode :
                    postSwitchedToGPSHoldFlyingMode(args.getString(0));
                break;                
                case PyzeMethodInt.postSwitchedToCustomFlyingMode :
                    postSwitchedToCustomFlyingMode(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postSetMaxAltitude :
                    postSetMaxAltitude(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postSetAutoReturnInSeconds :
                    postSetAutoReturnInSeconds(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postSetAutoReturnWhenLowMemory :
                    postSetAutoReturnWhenLowMemory(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postSetAutoReturnWhenLowBattery :
                    postSetAutoReturnWhenLowBattery(args.getInt(0), args.getString(1));
                break;
                

                case PyzeMethodInt.postWeatherRequestedForType :
                    postWeatherRequestedForType(args.getInt(0), args.getInt(1), args.getString(2));
                break;                
                case PyzeMethodInt.postWeatherHistoricalRequest :
                    postWeatherHistoricalRequest(args.getInt(0), args.getInt(1), args.getString(2));
                break;                
                case PyzeMethodInt.postWeatherStationsRequestWithClusterData :
                    postWeatherStationsRequestWithClusterData(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postWeatherMapLayersRequested :
                    postWeatherMapLayersRequested(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postWeatherRequestForUVIndexAtPoint :
                    postWeatherRequestForUVIndexAtPoint(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postWeatherResponseForType :
                    postWeatherResponseForType(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postWeatherResponseForHistoricalData :
                    postWeatherResponseForHistoricalData(args.getString(0));
                break;                
                case PyzeMethodInt.postWeatherStationResponseData :
                    postWeatherStationResponseData(args.getString(0));
                break;                
                case PyzeMethodInt.postWeatherMapLayersResponse :
                    postWeatherMapLayersResponse(args.getString(0));
                break;                
                case PyzeMethodInt.postWeatherResponseForUVIndex :
                    postWeatherResponseForUVIndex(args.getString(0));
                break;                
                case PyzeMethodInt.postForecastRequestForKeywords :
                    postForecastRequestForKeywords(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postForecastResponseForKeywordsShort :
                    postForecastResponseForKeywordsShort(args.getString(0));
                break;                
                case PyzeMethodInt.postForecastFetch :
                    postForecastFetch(args.getInt(0), args.getString(1));
                break;                
                case PyzeMethodInt.postForecastFetchResponse :
                    postForecastFetchResponse(args.getString(0));
                break;


                case PyzeMethodInt.postRequestedPhoneCallback :
                    postRequestedPhoneCallback(args.getString(0));
                break;                
                case PyzeMethodInt.postLiveChatStartedWithTopic :
                    postLiveChatStartedWithTopic(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postLiveChatEndedWithTopic :
                    postLiveChatEndedWithTopic(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postTicketCreated :
                    postTicketCreated(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.postFeedbackReceived:
                    postFeedbackReceived(args.getString(0), args.getString(1));
                break;                
                case PyzeMethodInt.postQualityOfServiceRated :
                    postQualityOfServiceRated(args.getString(0), args.getString(1), args.getString(2));
                break;


                case PyzeMethodInt.pyzeCommerceSupportPostLiveChatStartedWithTopic :
                    pyzeCommerceSupportPostLiveChatStartedWithTopic(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.pyzeCommerceSupportPostLiveChatEndedWithTopic :
                    pyzeCommerceSupportPostLiveChatEndedWithTopic(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.pyzeCommerceSupportPostTicketCreated :
                    pyzeCommerceSupportPostTicketCreated(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;                
                case PyzeMethodInt.pyzeCommerceSupportPostFeedbackReceived :
                    pyzeCommerceSupportPostFeedbackReceived(args.getString(0), args.getString(1), args.getString(2));
                break;                
                case PyzeMethodInt.pyzeCommerceSupportPostQualityOfServiceRated :
                    pyzeCommerceSupportPostQualityOfServiceRated(args.getString(0), args.getString(1), args.getString(2), args.getString(3));
                break;
                

                case PyzeMethodInt.showInAppNotification :
                    showInAppNotification(callbackContext);
                break;                
                case PyzeMethodInt.showInAppNotificatonWithCustomAttributes :
                    showInAppNotificatonWithCustomAttributes(args.getInt(0), args.getString(1), callbackContext);
                break;                
                case PyzeMethodInt.closeInAppMessage :
                    closeInAppMessage();
                break;                
                case PyzeMethodInt.countNewUnFetchedMessages :
                    countNewUnFetchedMessages(callbackContext);
                break;                
                case PyzeMethodInt.getMessageHeaderOfType :
                    getMessageHeaderOfType(args.getInt(0), callbackContext);
                break;                
                case PyzeMethodInt.getMessageWithContentID :
                    getMessageWithContentID(args.getString(0), args.getString(1), callbackContext);
                break;
                
                case PyzeMethodInt.setUserIdentifier :
                    setUserIdentifier(args.getString(0));
                break;
                case PyzeMethodInt.resetUserIdentifier :
                    resetUserIdentifier();
                break;
                case PyzeMethodInt.postTraits :
                    postTraits(args.getString(0));
                break;

                case PyzeMethodInt.postSecondsOnScene :
                    postSecondsOnScene(args.getString(0), (float)args.getDouble(1));
                break;


                case PyzeMethodInt.getTags :
                    getTags(callbackContext);
                break;
                case PyzeMethodInt.isTagSet :
                    isTagSet(args.getString(0), callbackContext);
                break;
                case PyzeMethodInt.areAnyTagSet :
                    areAnyTagSet(args.getString(0), callbackContext);
                break;
                case PyzeMethodInt.areAllTagSet :
                    areAllTagSet(args.getString(0), callbackContext);
                break;
            }
            return true;
        }
        // if ("echo".equals(action)) {
        //     echo(args.getString(0), callbackContext);
        //     return true;
        // } 
        // else if ("postCustomEvent".equals(action)) {
        //     postCustomEvent(args.getString(0));
        //     return true;
        // }
        return false;
    }

    private void echo(
        String msg,
        CallbackContext callbackContext
    ) {
        if (msg == null || msg.length() == 0) {
            callbackContext.error("Empty message!");
        } else {
            Toast.makeText(
                webView.getContext(),
                msg,
                Toast.LENGTH_LONG
            ).show();
            callbackContext.success(msg);
        }
    }

    /***
     * Region Pyze Custom Event
     ***/
    
    public void postCustomEvent(String eventName) {
        PyzeEvents.postCustomEvent(eventName);
    }

    
    public void postCustomEventWithAttributes(String eventName, String customAttributes) {
        PyzeEvents.postCustomEventWithAttributes(eventName,stringToHashMap(customAttributes));
    }

    
    public void postTimedEventWithName(String eventName, double timerReference) {
        PyzeEvents.postTimedWithEventName(eventName,(long)timerReference);
    }

    
    public void postTimedEventWithNameAndAttributes(String eventName, double timerReference, String customAttributes) {
        PyzeEvents.postTimedWithEventName(eventName,timerReference,stringToHashMap(customAttributes));
    }
    /***
     End Region Pyze Custom Event
     ***/

    /***
     * Region PyzeAdvocacy
     ***/
    
    public void postRequestFeedback(String customAttributes) {
        PyzeEvents.PyzeAdvocacy.postRequestForFeedback(stringToHashMap(customAttributes));
    }

    
    public void postFeedbackProvided(String customAttributes) {
        PyzeEvents.PyzeAdvocacy.postFeedbackProvided(stringToHashMap(customAttributes));
    }

    
    public void postRequestRating(String customAttributes) {
        PyzeEvents.PyzeAdvocacy.postRequestRating(stringToHashMap(customAttributes));
    }
    /***
     End Region PyzeAdvocacy
     ***/

    /***
     * Region PyzeAd
     ***/
    
    public void postAdRequested(String adNetwork, String appScreen, String size, String type, String customAttributes) {
        PyzeEvents.PyzeAd.postAdRequested(adNetwork,appScreen,size,type,stringToHashMap(customAttributes));
    }

    
    public void postAdReceived(String adNetwork, String appScreen, String resultCode, boolean success, String customAttributes) {
        PyzeEvents.PyzeAd.postAdReceived(adNetwork,appScreen,resultCode,success,stringToHashMap(customAttributes));
    }

    
    public void postAdClicked(String adNetwork, String appScreen, String adCode, boolean success, String errorCode, String customAttributes) {
        PyzeEvents.PyzeAd.postAdClicked(adNetwork,appScreen,adCode,success,errorCode,stringToHashMap(customAttributes));
    }

/***
 End Region PyzeAd
 ***/

    /***
     * Region PyzeAccount
     ***/

    
    public void postLoginOffered(String customAttributes) {
        PyzeEvents.PyzeAccount.postLoginOffered(stringToHashMap(customAttributes));
    }

    
    public void postLoginStarted(String customAttributes) {
        PyzeEvents.PyzeAccount.postLoginStarted(stringToHashMap(customAttributes));
    }

    
    public void postSocialLoginOffered(String type, String customAttributes) {
        PyzeEvents.PyzeAccount.postSocialLoginOffered(type,stringToHashMap(customAttributes));
    }

    
    public void postSocialLoginStarted(String type, String customAttributes) {
        PyzeEvents.PyzeAccount.postSocialLoginStarted(type,stringToHashMap(customAttributes));
    }

    
    public void postSocialLoginCompleted(String type, String customAttributes) {
        PyzeEvents.PyzeAccount.postSocialLoginCompleted(type,stringToHashMap(customAttributes));
    }

    
    public void postPasswordResetCompleted(String customAttributes) {
        PyzeEvents.PyzeAccount.postPasswordResetCompleted(stringToHashMap(customAttributes));
    }

    
    public void postRegistrationOffered(String customAttributes) {
        PyzeEvents.PyzeAccount.postRegistrationOffered(stringToHashMap(customAttributes));
    }

    
    public void postRegistrationStarted(String customAttributes) {
        PyzeEvents.PyzeAccount.postRegistrationStarted(stringToHashMap(customAttributes));
    }

    
    public void postRegistrationCompleted(String customAttributes) {
        PyzeEvents.PyzeAccount.postRegistrationCompleted(stringToHashMap(customAttributes));
    }

    
    public void postLoginCompleted(boolean success, String errCodeString, String customAttributes) {
        PyzeEvents.PyzeAccount.postLoginCompleted(success,errCodeString,stringToHashMap(customAttributes));
    }

    
    public void postLogoutCompleted(String customAttributes) {
        PyzeEvents.PyzeAccount.postLogoutCompleted(stringToHashMap(customAttributes));
    }

    
    public void postPasswordResetRequest(String customAttributes) {
        PyzeEvents.PyzeAccount.postPasswordResetRequested(stringToHashMap(customAttributes));
    }
/***
 End Region PyzeAccount
 ***/

    /***
     * Region PyzeContent
     ***/
    
    public void postViewed(String contentName, String categoryName, String contentId, String customAttributes) {
        PyzeEvents.PyzeContent.postViewed(contentName,categoryName,contentId,stringToHashMap(customAttributes));
    }

    
    public void postSearched(String searchString, String customAttributes) {
        PyzeEvents.PyzeContent.postSearched(searchString,stringToHashMap(customAttributes));
    }

    
    public void postRatedOn5PointScale(String contentName, String categoryName, String contentId, int rating, String customAttributes) {
        PyzeEvents.PyzeContent.postRatedOn5PointScale(contentName,categoryName,contentId,rating,stringToHashMap(customAttributes));
    }

    
    public void postRatedThumbsUp(String contentName, String categoryName, String contentId, String customAttributes) {
        PyzeEvents.PyzeContent.postRatedThumbsUp(contentName,categoryName,contentId,stringToHashMap(customAttributes));
    }

    
    public void postRatedThumbsDown(String contentName, String categoryName, String contentId, String customAttributes) {
        PyzeEvents.PyzeContent.postRatedThumbsDown(contentName,categoryName,contentId,stringToHashMap(customAttributes));
    }

/***
 End Region PyzeContent
 ***/

    /***
     * Region PyzeMessaging
     ***/
    
    public void postMessageSent(String uniqueId, String customAttributes) {
        PyzeEvents.PyzeMessaging.postMessageSent(uniqueId,stringToHashMap(customAttributes));
    }

    
    public void postMessageSentOfType(int messageType, String uniqueId, String customAttributes) {
        PyzeEvents.PyzeMessaging.postMessageSentOfType(Constants.PyzeMessageType.values()[messageType],uniqueId,stringToHashMap(customAttributes));
    }

    
    public void postMessageReceived(String uniqueId, String customAttributes) {
        PyzeEvents.PyzeMessaging.postMessageReceived(uniqueId,stringToHashMap(customAttributes));
    }

    
    public void postMessageNewConversation(String uniqueId, String customAttributes) {
        PyzeEvents.PyzeMessaging.postMessageNewConversation(uniqueId,stringToHashMap(customAttributes));
    }

    
    public void postMessageVoiceCall(String uniqueId, String customAttributes) {
        PyzeEvents.PyzeMessaging.postMessageVoiceCall(uniqueId,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeMessaging
     ***/


    /***
     * Region PyzeInAppPurchaseRevenue
     ***/
    
    public void postPriceListViewed(String appScreenRequestFromId, String customAttributes) {
        PyzeEvents.PyzeInAppPurchaseRevenue.postPriceListViewed(appScreenRequestFromId,stringToHashMap(customAttributes));
    }

    
    public void postBuyItem(String itemName, String currency, float price, String itemType, String itemSKU, String quantity, String appScreenRequestFromId, boolean status, String successOrErrorCode, String customAttributes) {
        PyzeEvents.PyzeInAppPurchaseRevenue.postBuyItem(itemName,currency, String.valueOf(price),itemType,itemSKU,quantity,appScreenRequestFromId,status,successOrErrorCode,stringToHashMap(customAttributes));
    }

    
    public void postBuyItemShort(String itemName, float price, String currencyISO4217Code, String customAttributes) {
        PyzeEvents.PyzeInAppPurchaseRevenue.postBuyItem(itemName, String.valueOf(price),currencyISO4217Code,stringToHashMap(customAttributes));
    }

    
    public void postBuyItemUSD(String itemName, float price, String customAttributes) {
        PyzeEvents.PyzeInAppPurchaseRevenue.postBuyItemInUSD(itemName, String.valueOf(price),stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeInAppPurchaseRevenue
     ***/


    /***
     * Region PyzeTasks
     ***/
    
    public void postAddToCalendarWithAttributes(String customAttributes) {
        PyzeEvents.PyzeTasks.postAddToCalendarwithAttributes(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeTasks
     ***/

    /***
     * Region PyzeSocial
     ***/
    
    public void postSocialContentShareForNetworkName(String socialNetworkName, String contentReference, String category, String customAttributes) {
        PyzeEvents.PyzeSocial.postSocialContentShareForNetworkName(socialNetworkName,contentReference,category,stringToHashMap(customAttributes));
    }

    
    public void postLiked(String socialNetworkName, String contentReference, String category, String customAttributes) {
        PyzeEvents.PyzeSocial.postLiked(socialNetworkName,contentReference,category,stringToHashMap(customAttributes));
    }

    
    public void postFollowed(String socialNetworkName, String contentReference, String category, String customAttributes) {
        PyzeEvents.PyzeSocial.postFollowed(socialNetworkName,contentReference,category,stringToHashMap(customAttributes));
    }

    
    public void postSubscribed(String socialNetworkName, String contentReference, String category, String customAttributes) {
        PyzeEvents.PyzeSocial.postSubscribed(socialNetworkName,contentReference,category,stringToHashMap(customAttributes));
    }

    
    public void postInvitedFriends(String socialNetworkName, String customAttributes) {
        PyzeEvents.PyzeSocial.postInvitedFriend(socialNetworkName,stringToHashMap(customAttributes));
    }

    
    public void postFoundFriends(String source, String customAttributes) {
        PyzeEvents.PyzeSocial.postFoundFriends(source,stringToHashMap(customAttributes));
    }
/***
 End Region PyzeSocial
 ***/

    /***
     * Region PyzeCommerceDiscovery
     ***/
    
    public void pyzeCommerceDiscoveryPostSearched(String searchString, int latency, String customAttributes) {
        PyzeEvents.PyzeCommerceDiscovery.postSearched(searchString,latency,stringToHashMap(customAttributes));
    }

    
    public void postBrowsedCategory(String category, String customAttributes) {
        PyzeEvents.PyzeCommerceDiscovery.postBrowsedCategory(category,stringToHashMap(customAttributes));
    }

    
    public void postBrowsedDeals(String uniqueDealId, String customAttributes) {
        PyzeEvents.PyzeCommerceDiscovery.postBrowsedDeals(uniqueDealId,stringToHashMap(customAttributes));
    }

    
    public void postBrowsedRecommendations(String uniqueRecommendationID, String customAttributes) {
        PyzeEvents.PyzeCommerceDiscovery.postBrowsedRecommendations(uniqueRecommendationID,stringToHashMap(customAttributes));
    }

    
    public void postBrowsedPrevOrders(String rangeStart, String rangeEnd, String customAttributes) {
        PyzeEvents.PyzeCommerceDiscovery.postBrowsedPrevOrders(rangeStart,rangeEnd,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceDiscovery
     ***/

    /***
     * Region PyzeCommerceCuratedList
     ***/
    
    public void postCreated(String uniqueCuratedListID, String curatedListType, String customAttributes) {
        PyzeEvents.PyzeCommerceCuratedList.postCreated(uniqueCuratedListID,curatedListType,stringToHashMap(customAttributes));
    }

    
    public void postBrowsed(String curatedList, String curatedListCreator, String customAttributes) {
        PyzeEvents.PyzeCommerceCuratedList.postBrowsed(curatedList,curatedListCreator,stringToHashMap(customAttributes));
    }

    
    public void postAddedItem(String uniqueCuratedListId, String itemCategory, String itemId, String customAttributes) {
        PyzeEvents.PyzeCommerceCuratedList.postAddedItem(uniqueCuratedListId,itemCategory,itemId,stringToHashMap(customAttributes));
    }

    
    public void postRemovedItem(String uniqueCuratedListId, String itemCategory, String itemId, String customAttributes) {
        PyzeEvents.PyzeCommerceCuratedList.postRemovedItem(uniqueCuratedListId,itemCategory,itemId,stringToHashMap(customAttributes));
    }

    
    public void postShared(String curatedList, String curatedListCreator, String customAttributes) {
        PyzeEvents.PyzeCommerceCuratedList.postShared(curatedList,curatedListCreator,stringToHashMap(customAttributes));
    }

    
    public void postPublished(String curatedList, String curatedListCreator, String customAttributes) {
        PyzeEvents.PyzeCommerceCuratedList.postPublished(curatedList,curatedListCreator,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceCuratedList
     ***/


    /***
     * Region PyzeCommerceWishList
     ***/
    
    public void pyzeCommerceWishListPostCreated(String uniqueWishListId, String wishListType, String customAttributes) {
        PyzeEvents.PyzeCommerceWishList.postCreated(uniqueWishListId,wishListType,stringToHashMap(customAttributes));
    }

    
    public void pyzeCommerceWishListPostBrowsed(String uniqueWishListId, String customAttributes) {
        PyzeEvents.PyzeCommerceWishList.postBrowsed(uniqueWishListId,stringToHashMap(customAttributes));
    }

    
    public void pyzeCommerceWishListPostAddedItem(String uniqueWishListId, String itemCategory, String itemId, String customAttributes) {
        PyzeEvents.PyzeCommerceWishList.postAddedItem(uniqueWishListId,itemCategory,itemId,stringToHashMap(customAttributes));
    }

    
    public void pyzeCommerceWishListPostRemovedItem(String uniqueWishListId, String itemCategory, String itemId, String customAttributes) {
        PyzeEvents.PyzeCommerceWishList.postRemovedItem(uniqueWishListId,itemCategory,itemId,stringToHashMap(customAttributes));
    }

    
    public void pyzeCommerceWishListPostShared(String uniqueWishListId, String customAttributes) {
        PyzeEvents.PyzeCommerceWishList.postShared(uniqueWishListId,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceWishList
     ***/


    /***
     * Region PyzeCommerceBeacon
     ***/
    
    public void postEnteredRegion(String beaconUUID, String beaconMajor, String beaconMinor, String uniqueRegionIdentifier, String customAttributes) {
        PyzeEvents.PyzeCommerceBeacon.postEnteredRegion(beaconUUID,beaconMajor,beaconMinor,uniqueRegionIdentifier,stringToHashMap(customAttributes));
    }

    
    public void postExitedRegion(String beaconUUID, String beaconMajor, String beaconMinor, String uniqueRegionIdentifier, String customAttributes) {
        PyzeEvents.PyzeCommerceBeacon.postExitedRegion(beaconUUID,beaconMajor,beaconMinor,uniqueRegionIdentifier,stringToHashMap(customAttributes));
    }

    
    public void postTransactedRegion(String beaconUUID, String beaconMajor, String beaconMinor, String uniqueRegionIdentifier, String proximity, String actionId, String customAttributes) {
        PyzeEvents.PyzeCommerceBeacon.postTransactedInRegion(beaconUUID,beaconMajor,beaconMinor,uniqueRegionIdentifier,proximity,actionId,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceBeacon
     ***/

    /***
     * Region PyzeCommerceCart
     ***/
    
    public void postAddItem(String cartId, String itemCategory, String itemId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItem(cartId,itemCategory,itemId,stringToHashMap(customAttributes));
    }

    
    public void postAddItemFromDeals(String cartId, String itemCategory, String itemId, String uniqueDealId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItemFromDeals(cartId,itemCategory,itemId,uniqueDealId,stringToHashMap(customAttributes));
    }

    
    public void postAddItemFromWishList(String cartId, String itemCategory, String itemId, String uniqueWishListId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItemFromWishList(cartId,itemCategory,itemId,uniqueWishListId,stringToHashMap(customAttributes));
    }

    
    public void postAddItemFromCuratedList(String cartId, String itemCategory, String itemId, String uniqueCuratedListId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItemFromCuratedList(cartId,itemCategory,itemId,uniqueCuratedListId,stringToHashMap(customAttributes));
    }

    
    public void postAddItemFromRecommendations(String cartId, String itemCategory, String itemId, String uniqueRecommendationId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItemFromRecommendations(cartId,itemCategory,itemId,uniqueRecommendationId,stringToHashMap(customAttributes));
    }

    
    public void postAddItemFromPreviousOrders(String cartId, String itemCategory, String itemId, String previousOrderId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItemFromPreviousOrders(cartId,itemCategory,itemId,previousOrderId,stringToHashMap(customAttributes));
    }

    
    public void postAddItemFromSearchResults(String cartId, String itemCategory, String itemId, String searchString, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItemFromSearchResults(cartId,itemCategory,itemId,searchString,stringToHashMap(customAttributes));
    }

    
    public void postAddItemFromSubscriptionList(String cartId, String itemCategory, String itemId, String uniqueSubscriptionId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postAddItemFromSubcriptionList(cartId,itemCategory,itemId,uniqueSubscriptionId,stringToHashMap(customAttributes));
    }

    
    public void postRemoveItemFromCart(String cartId, String itemCategory, String itemId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postRemoveItemFromCart(cartId,itemCategory,itemId,stringToHashMap(customAttributes));
    }

    
    public void postView(String cartId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postView(cartId,stringToHashMap(customAttributes));
    }

    
    public void postShare(String cartId, String sharedWith, String itemId, String customAttributes) {
        PyzeEvents.PyzeCommerceCart.postShare(cartId,sharedWith,itemId,stringToHashMap(customAttributes));
    }

/***
 End Region PyzeCommerceCart
 ***/


    /***
     * Region PyzeCommerceItem
     ***/
    
    public void postViewedItem(String customAttributes) {
        PyzeEvents.PyzeCommerceItem.postViewedItem(stringToHashMap(customAttributes));
    }

    
    public void postScannedItem(String customAttributes) {
        PyzeEvents.PyzeCommerceItem.postScannedItem(stringToHashMap(customAttributes));
    }

    
    public void postViewedReviews(String customAttributes) {
        PyzeEvents.PyzeCommerceItem.postViewedReviews(stringToHashMap(customAttributes));
    }

    
    public void postViewedDetails(String customAttributes) {
        PyzeEvents.PyzeCommerceItem.postViewedDetails(stringToHashMap(customAttributes));
    }

    
    public void postViewedPrice(String customAttributes) {
        PyzeEvents.PyzeCommerceItem.postViewedPrice(stringToHashMap(customAttributes));
    }

    
    public void postItemShare(String customAttributes) {
        PyzeEvents.PyzeCommerceItem.postItemShareItem(stringToHashMap(customAttributes));
    }

    
    public void postItemRateOn5Scale(String itemSKU, String rating, String customAttributes) {
        PyzeEvents.PyzeCommerceItem.postItemRateOn5Scale(itemSKU,rating,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceItem
     ***/


    /***
     * Region PyzeCommerceCheckout
     ***/
    
    public void postCheckoutStarted(String customAttributes) {
        PyzeEvents.PyzeCommerceCheckout.postCheckoutStarted(stringToHashMap(customAttributes));
    }

    
    public void postCheckoutCompleted(String customAttributes) {
        PyzeEvents.PyzeCommerceCheckout.postCheckoutCompleted(stringToHashMap(customAttributes));
    }

    
    public void postCheckoutAbandoned(String customAttributes) {
        PyzeEvents.PyzeCommerceCheckout.postCheckoutAbandoned(stringToHashMap(customAttributes));
    }

    
    public void postCheckoutFailed(String customAttributes) {
        PyzeEvents.PyzeCommerceCheckout.postCheckoutFailed(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceCheckout
     ***/


    /***
     * Region PyzeCommerceShipping
     ***/
    
    public void postShippingStarted(String customAttributes) {
        PyzeEvents.PyzeCommerceShipping.postShippingStarted(stringToHashMap(customAttributes));
    }

    
    public void postShippingCompleted(String customAttributes) {
        PyzeEvents.PyzeCommerceShipping.postShippingCompleted(stringToHashMap(customAttributes));
    }

    
    public void postShippingAbandoned(String customAttributes) {
        PyzeEvents.PyzeCommerceShipping.postShippingAbandoned(stringToHashMap(customAttributes));
    }

    
    public void postShippingFailed(String customAttributes) {
        PyzeEvents.PyzeCommerceShipping.postShippingFailed(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceShipping
     ***/


    /***
     * Region PyzeCommerceBilling
     ***/
    
    public void postBillingStarted(String customAttributes) {
        PyzeEvents.PyzeCommerceBilling.postBillingStarted(stringToHashMap(customAttributes));
    }

    
    public void postBillingCompleted(String customAttributes) {
        PyzeEvents.PyzeCommerceBilling.postBillingCompleted(stringToHashMap(customAttributes));
    }

    
    public void postBillingAbandoned(String customAttributes) {
        PyzeEvents.PyzeCommerceBilling.postBillingAbandoned(stringToHashMap(customAttributes));
    }

    
    public void postBillingFailed(String customAttributes) {
        PyzeEvents.PyzeCommerceBilling.postBillingFailed(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceBilling
     ***/


    /***
     * Region PyzeCommercePayment
     ***/
    
    public void postPaymentStarted(String customAttributes) {
        PyzeEvents.PyzeCommercePayment.postPaymentStarted(stringToHashMap(customAttributes));
    }

    
    public void postPaymentCompleted(String customAttributes) {
        PyzeEvents.PyzeCommercePayment.postPaymentCompleteed(stringToHashMap(customAttributes));
    }

    
    public void postPaymentAbandoned(String customAttributes) {
        PyzeEvents.PyzeCommercePayment.postPaymentAbandoned(stringToHashMap(customAttributes));
    }

    
    public void postPaymentFailed(String customAttributes) {
        PyzeEvents.PyzeCommercePayment.postPaymentFailed(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommercePayment
     ***/


    /***
     * Region PyzeExplicitActivation
     ***/
    
    public void postWithAttributes(String customAttributes) {
        PyzeEvents.PyzeExplicitActivation.post(stringToHashMap(customAttributes));
    }

    
    public void post() {
        PyzeEvents.PyzeExplicitActivation.post();
    }

    /***
     * End Region PyzeExplicitActivation
     ***/


    /***
     * Region PyzeGaming
     ***/
    
    public void postLevelStarted(String level, String customAttributes) {
        PyzeEvents.PyzeGaming.postLevelStarted(level,stringToHashMap(customAttributes));
    }

    
    public void postLevelEnded(String level, String score, String success, String customAttributes) {
        PyzeEvents.PyzeGaming.postLevelEnded(level,score,success,stringToHashMap(customAttributes));
    }

    
    public void postPowerUpConsumed(String level, String type, String value, String customAttributes) {
        PyzeEvents.PyzeGaming.postPowerUpConsumed(level,type,value,stringToHashMap(customAttributes));
    }

    
    public void postInGameItemPurchased(String uniqueItemId, String itemType, String value, String customAttributes) {
        PyzeEvents.PyzeGaming.postInGameItemPurchased(uniqueItemId,itemType,value,stringToHashMap(customAttributes));
    }

    
    public void postAchievementEarned(String uniqueAchievementId, String type, String customAttributes) {
        PyzeEvents.PyzeGaming.postAchievementEarned(uniqueAchievementId,type,stringToHashMap(customAttributes));
    }

    
    public void postSummaryViewed(String level, String type, String customAttributes) {
        PyzeEvents.PyzeGaming.postSummaryViewed(level,type,stringToHashMap(customAttributes));
    }

    
    public void postLeaderBoardViewed(String level, String score, String customAttributes) {
        PyzeEvents.PyzeGaming.postLeaderBoardViewed(level,score,stringToHashMap(customAttributes));
    }

    
    public void postScorecardViewed(String level, String score, String customAttributes) {
        PyzeEvents.PyzeGaming.postScorecardViewed(level,score,stringToHashMap(customAttributes));
    }

    
    public void postHelpViewed(String helpTopicId, String customAttributes) {
        PyzeEvents.PyzeGaming.postHelpViewed(helpTopicId,stringToHashMap(customAttributes));
    }

    
    public void postTutorialViewed(String helpTopicId, String customAttributes) {
        PyzeEvents.PyzeGaming.postTutorialViewed(helpTopicId,stringToHashMap(customAttributes));
    }

    
    public void postFriendChallenged(String customAttributes) {
        PyzeEvents.PyzeGaming.postFriendChallenged(stringToHashMap(customAttributes));
    }

    
    public void postChallengeAccepted(String customAttributes) {
        PyzeEvents.PyzeGaming.postChallengeAccepted(stringToHashMap(customAttributes));
    }

    
    public void postChallengeDeclined(String customAttributes) {
        PyzeEvents.PyzeGaming.postChallengeDeclined(stringToHashMap(customAttributes));
    }

    
    public void postGameStarted(String level, String customAttributes) {
        PyzeEvents.PyzeGaming.postGameStart(level,stringToHashMap(customAttributes));
    }

    
    public void postGameEnd(String levelsPlayed, String levelsWon, String customAttributes) {
        PyzeEvents.PyzeGaming.postGameEnd(levelsPlayed,levelsWon,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeGaming
     ***/

    /***
     * Region PyzeHealthAndFitness
     ***/
    
    public void postStarted(String customAttributes) {
        PyzeEvents.PyzeHealthAndFitness.postStarted(stringToHashMap(customAttributes));
    }

    
    public void postEnded(String customAttributes) {
        PyzeEvents.PyzeHealthAndFitness.postEnded(stringToHashMap(customAttributes));
    }

    
    public void postAchievementReceived(String customAttributes) {
        PyzeEvents.PyzeHealthAndFitness.postAchievementReceived(stringToHashMap(customAttributes));
    }

    
    public void postStepGoalCompleted(String customAttributes) {
        PyzeEvents.PyzeHealthAndFitness.postStepGoalCompleted(stringToHashMap(customAttributes));
    }

    
    public void postGoalCompleted(String customAttributes) {
        PyzeEvents.PyzeHealthAndFitness.postGoalCompleted(stringToHashMap(customAttributes));
    }

    
    public void postChallengedFriend(String customAttributes) {
        PyzeEvents.PyzeHealthAndFitness.postChallengedFriend(stringToHashMap(customAttributes));
    }

    
    public void pyzeHealthAndFitnessPostChallengeAccepted(String customAttributes) {
        PyzeEvents.PyzeHealthAndFitness.postChallengeAccepted(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeHealthAndFitness
     ***/


    /***
     * Region PyzeMedia
     ***/
    
    public void pyzeMediaPostPlayedMedia(String contentName, String type, String categoryName, String percent, String contentId, String customAttributes) {
        PyzeEvents.PyzeMedia.postPlayedMedia(contentName,type,categoryName,percent,contentId,stringToHashMap(customAttributes));
    }

    
    public void pyzeMediaPostSearched(String searchString, String customAttributes) {
        PyzeEvents.PyzeMedia.postSearched(searchString,stringToHashMap(customAttributes));
    }

    
    public void postRateOn5PointScale(String contentName, String categoryName, String contentId, int rating, String customAttributes) {
        PyzeEvents.PyzeMedia.postRateOn5PointScale(contentName,categoryName,contentId,rating,stringToHashMap(customAttributes));
    }

    
    public void pyzeMediaPostRatedThumbsUp(String contentName, String categoryName, String contentId, String customAttributes) {
        PyzeEvents.PyzeMedia.postRatedThumbsUp(contentName,categoryName,contentId,stringToHashMap(customAttributes));
    }

    
    public void pyzeMediaPostRatedThumbsDown(String contentName, String categoryName, String contentId, String customAttributes) {
        PyzeEvents.PyzeMedia.postRatedThumbsDown(contentName,categoryName,contentId,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeMedia
     ***/


    /***
     * Region PyzeBitcoin
     ***/
    
    public void postSentBitCoins(String customAttributes) {
        PyzeEvents.PyzeBitcoin.postSentBitCoins(stringToHashMap(customAttributes));
    }

    
    public void postRequestedBitCoins(String customAttributes) {
        PyzeEvents.PyzeBitcoin.postRequestedBitCoins(stringToHashMap(customAttributes));
    }

    
    public void postReceivedBitCoins(String customAttributes) {
        PyzeEvents.PyzeBitcoin.postReceivedBitCoins(stringToHashMap(customAttributes));
    }

    
    public void postImportedPrivateKey(String customAttributes) {
        PyzeEvents.PyzeBitcoin.postImportedPrivateKey(stringToHashMap(customAttributes));
    }

    
    public void postViewedTransaction(String customAttributes) {
        PyzeEvents.PyzeBitcoin.postViewedTransactions(stringToHashMap(customAttributes));
    }

    
    public void postScannedPrivateKey(String customAttributes) {
        PyzeEvents.PyzeBitcoin.postScannedPrivateKey(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeBitcoin
     ***/


    /***
     * Region PyzeCommerceRevenue
     ***/
    
    public void postRevenue(int revenue, String customAttributes) {
        PyzeEvents.PyzeCommerceRevenue.postRevenue(revenue,stringToHashMap(customAttributes));
    }

    
    public void postRevenueDetailed(int revenue, String paymentRevenue, String customAttributes) {
        PyzeEvents.PyzeCommerceRevenue.postRevenue(revenue, paymentRevenue, stringToHashMap(customAttributes));
    }

    
    public void postRevenueUsingApplePay(int revenue, String customAttributes) {
        PyzeEvents.PyzeCommerceRevenue.postRevenueUsingApplePay(revenue,stringToHashMap(customAttributes));
    }

    
    public void postRevenueUsingSamsungPay(int revenue, String customAttributes) {
        PyzeEvents.PyzeCommerceRevenue.postRevenueUsingSamsungPay(revenue, stringToHashMap(customAttributes));
    }

    
    public void postRevenueUsingGooglePay(int revenue, String customAttributes) {
        PyzeEvents.PyzeCommerceRevenue.postRevenueUsingGooglePay(revenue, stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceRevenue
     ***/


    /***
     * Region PyzeDrone
     ***/
    
    public void postPreflightCheckCompleted(String overallStatus, String storageStatus, int droneBatteryChargePercent, int deviceBatteryChargePercent, String calibrationStatus, String gpsStatus, String customAttributes) {
        PyzeEvents.PyzeDrone.postPreflightCheckCompleted(overallStatus,storageStatus,droneBatteryChargePercent,deviceBatteryChargePercent,calibrationStatus,gpsStatus,stringToHashMap(customAttributes));
    }

    
    public void postInflightCheckCompleted(String overallStatus, String rollStatus, String pitchStatus, String yawStatus, String throttleStatus, String trimmingSettings, String customAttributes) {
        PyzeEvents.PyzeDrone.postInflightCheckCompleted(overallStatus,rollStatus,pitchStatus,yawStatus,throttleStatus,trimmingSettings,stringToHashMap(customAttributes));
    }

    
    public void postConnected(String customAttributes) {
        PyzeEvents.PyzeDrone.postConnected(stringToHashMap(customAttributes));
    }

    
    public void postDisconnected(String code, String customAttributes) {
        PyzeEvents.PyzeDrone.postDisconnected(code,stringToHashMap(customAttributes));
    }

    
    public void postAirborne(String status, String customAttributes) {
        PyzeEvents.PyzeDrone.postAirborne(status,stringToHashMap(customAttributes));
    }

    
    public void postLanded(String status, String customAttributes) {
        PyzeEvents.PyzeDrone.postLanded(status,stringToHashMap(customAttributes));
    }

    
    public void postFlightPathCreated(String uniqueFlightPathId, String customAttributes) {
        PyzeEvents.PyzeDrone.postFlightPathCreated(uniqueFlightPathId,stringToHashMap(customAttributes));
    }

    
    public void postFlightPathUploaded(String uniqueFlightPathId, String customAttributes) {
        PyzeEvents.PyzeDrone.postFlightPathUploaded(uniqueFlightPathId,stringToHashMap(customAttributes));
    }

    
    public void postFlightPathEdited(String uniqueFlightPathId, String customAttributes) {
        PyzeEvents.PyzeDrone.postFlightPathEdited(uniqueFlightPathId,stringToHashMap(customAttributes));
    }

    
    public void postFlightPathDeleted(String uniqueFlightPathId, String customAttributes) {
        PyzeEvents.PyzeDrone.postFlightPathDeleted(uniqueFlightPathId,stringToHashMap(customAttributes));
    }

    
    public void postFlightPathCompleted(String uniqueFlightPathId, String customAttributes) {
        PyzeEvents.PyzeDrone.postFlightPathCompleted(uniqueFlightPathId,stringToHashMap(customAttributes));
    }

    
    public void postFirstPersonViewEnabled(String status, String customAttributes) {
        PyzeEvents.PyzeDrone.postFirstPersonViewEnabled(status,stringToHashMap(customAttributes));
    }

    
    public void postFirstPersonViewDisabled(String status, String customAttributes) {
        PyzeEvents.PyzeDrone.postFirstPersonViewDisabled(status,stringToHashMap(customAttributes));
    }

    
    public void postStartedAerialVideo(String status, String customAttributes) {
        PyzeEvents.PyzeDrone.postStartedAerialVideo(status,stringToHashMap(customAttributes));
    }

    
    public void postStartedAerialVideoDetailed(String status, String videoIdentifer, String customAttributes) {
        PyzeEvents.PyzeDrone.postStartedAerialVideo(status,videoIdentifer,stringToHashMap(customAttributes));
    }

    
    public void postStoppedAerialVideo(String status, String secondsLength, String customAttributes) {
        PyzeEvents.PyzeDrone.postStoppedAerialVideo(status,secondsLength,stringToHashMap(customAttributes));
    }

    
    public void postTookAerialPicture(String status, String customAttributes) {
        PyzeEvents.PyzeDrone.postTookAerialPicture(status,stringToHashMap(customAttributes));
    }

    
    public void postStartedAerialTimelapse(String status, int totalshots, int secondsBetweenShots, String customAttributes) {
        PyzeEvents.PyzeDrone.postStartedAerialTimelapse(status,totalshots, String.valueOf(secondsBetweenShots),stringToHashMap(customAttributes));
    }

    
    public void postStoppedAerialTimelapse(String status, String customAttributes) {
        PyzeEvents.PyzeDrone.postStoppedAerialTimelapse(status,stringToHashMap(customAttributes));
    }

    
    public void postRequestedReturnToBase(String customAttributes) {
        PyzeEvents.PyzeDrone.postRequestedReturnToBase(stringToHashMap(customAttributes));
    }

    
    public void postSwitchedToHelicopterFlyingMode(String customAttributes) {
        PyzeEvents.PyzeDrone.postSwitchedToHelicopterFlyingMode(stringToHashMap(customAttributes));
    }

    
    public void postSwitchedToAltitudeFlyingMode(String customAttributes) {
        PyzeEvents.PyzeDrone.postSwitchedToAttitudeFlyingMode(stringToHashMap(customAttributes));
    }

    
    public void postSwitchedToGPSHoldFlyingMode(String customAttributes) {
        PyzeEvents.PyzeDrone.postSwitchedToGPSHoldFlyingMode(stringToHashMap(customAttributes));
    }

    
    public void postSwitchedToCustomFlyingMode(int mode, String customAttributes) {
        PyzeEvents.PyzeDrone.postSwitchedToCustomFlyingMode(mode,stringToHashMap(customAttributes));
    }

    
    public void postSetMaxAltitude(int altitudeInMeters, String customAttributes) {
        PyzeEvents.PyzeDrone.postSetMaxAltitude(altitudeInMeters,stringToHashMap(customAttributes));
    }

    
    public void postSetAutoReturnInSeconds(int seconds, String customAttributes) {
        PyzeEvents.PyzeDrone.postSetAutoReturnInSeconds(seconds,stringToHashMap(customAttributes));
    }

    
    public void postSetAutoReturnWhenLowMemory(int memoryLeftInKilobytes, String customAttributes) {
        PyzeEvents.PyzeDrone.postSetAutoReturnWhenLowMemory(memoryLeftInKilobytes,stringToHashMap(customAttributes));
    }

    
    public void postSetAutoReturnWhenLowBattery(int batterylevelPercent, String customAttributes) {
        PyzeEvents.PyzeDrone.postSetAutoReturnWhenLowBattery(batterylevelPercent,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeDrone
     ***/


    /***
     * Region PyzeWeatherAndForecast
     ***/
    
    public void postWeatherRequestedForType(int type, int howManyDays, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherRequestedForType(type,howManyDays,stringToHashMap(customAttributes));
    }

    
    public void postWeatherHistoricalRequest(int startInterval, int endInterval, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherHistoricalRequest(startInterval,endInterval,stringToHashMap(customAttributes));
    }

    
    public void postWeatherStationsRequestWithClusterData(String clusterData, String point, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherStationsRequestWithClusterData(clusterData,stringToPyzeGeoPoint(point),stringToHashMap(customAttributes));
    }

    
    public void postWeatherMapLayersRequested(String layerName, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherMapLayersRequested(layerName, stringToHashMap(customAttributes));
    }

    
    public void postWeatherRequestForUVIndexAtPoint(String point, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherRequestForUVIndexAtPoint(stringToPyzeGeoPoint(point),stringToHashMap(customAttributes));
    }

    
    public void postWeatherResponseForType(int type, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherResponseForType(type,stringToHashMap(customAttributes));
    }

    
    public void postWeatherResponseForHistoricalData(String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherResponseForHistoricalData(stringToHashMap(customAttributes));
    }

    
    public void postWeatherStationResponseData(String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherStationResponseData(stringToHashMap(customAttributes));
    }

    
    public void postWeatherMapLayersResponse(String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherMapLayersResponse(stringToHashMap(customAttributes));
    }

    
    public void postWeatherResponseForUVIndex(String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postWeatherResponseForUVIndex(stringToHashMap(customAttributes));
    }

    
    public void postForecastRequestForKeywords(String commaSeperatedKeywords, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postForecastRequestForKeywords(commaSeperatedKeywords, stringToHashMap(customAttributes));
    }

    
    public void postForecastResponseForKeywordsShort(String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postForecastResponseForKeywords(stringToHashMap(customAttributes));
    }

    
    public void postForecastFetch(int nDays, String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postForecastFetch(nDays,stringToHashMap(customAttributes));
    }

    
    public void postForecastFetchResponse(String customAttributes) {
        PyzeEvents.PyzeWeatherAndForecast.postForecastFetchResponse(stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeWeatherAndForecast
     ***/


    /***
     * Region PyzeSupport
     ***/

    
    public void postRequestedPhoneCallback(String customAttributes) {
        PyzeEvents.PyzeSupport.postRequestedPhonecallback(stringToHashMap(customAttributes));
    }

    
    public void postLiveChatStartedWithTopic(String topic, String customAttributes) {
        PyzeEvents.PyzeSupport.postLiveChatStartedWithTopic(topic,stringToHashMap(customAttributes));
    }

    
    public void postLiveChatEndedWithTopic(String topic, String customAttributes) {
        PyzeEvents.PyzeSupport.postLiveChatEndedWithTopic(topic,stringToHashMap(customAttributes));
    }

    
    public void postTicketCreated(String itemID, String topic, String customAttributes) {
        PyzeEvents.PyzeSupport.postTicketCreated(itemID,topic,stringToHashMap(customAttributes));
    }

    
    public void postFeedbackReceived(String feedback, String customAttributes) {
        PyzeEvents.PyzeSupport.postFeedbackReceived(feedback,stringToHashMap(customAttributes));
    }

    
    public void postQualityOfServiceRated(String comment, String rating, String customAttributes) {
        PyzeEvents.PyzeSupport.postQualityOfServiceRated(comment,rating,stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeSupport
     ***/


    /***
     * Region PyzeCommerceSupport
     ***/
    
    public void pyzeCommerceSupportPostLiveChatStartedWithTopic(String topic, String orderNumber, String customAttributes) {
        PyzeEvents.PyzeCommerceSupport.postLiveChatStartedWithTopic(topic,orderNumber,stringToHashMap(customAttributes));
    }

    
    public void pyzeCommerceSupportPostLiveChatEndedWithTopic(String topic, String orderNumber, String customAttributes) {
        PyzeEvents.PyzeCommerceSupport.postLiveChatEndedWithTopic(topic,orderNumber,stringToHashMap(customAttributes));
    }

    
    public void pyzeCommerceSupportPostTicketCreated(String topic, String itemID, String orderNumber, String customAttributes) {
        PyzeEvents.PyzeCommerceSupport.postTicketCreated(topic,itemID,orderNumber,stringToHashMap(customAttributes));
    }

    
    public void pyzeCommerceSupportPostFeedbackReceived(String feedback, String orderNumber, String customAttributes) {
        PyzeEvents.PyzeCommerceSupport.postFeedbackReceived(feedback,orderNumber,stringToHashMap(customAttributes));
    }

    public void pyzeCommerceSupportPostQualityOfServiceRated(String comment, String rating, String orderNumber, String customAttributes) {
        PyzeEvents.PyzeCommerceSupport.postQualityOfServiceRated(comment,rating,orderNumber, stringToHashMap(customAttributes));
    }

    /***
     * End Region PyzeCommerceSupport
     ***/

    /***
     * Region PyzeInAppMessages
     ***/

    public void showInAppNotification(final CallbackContext callbackContext) {
        Pyze.showInAppNotificationUI((Activity)webView.getContext(), new InAppNotificationTemplateDialogFragment.OnButtonClickListener() {
            @Override
            public void onButtonClicked(Pyze.InAppStatus inAppStatus) {
                //invoke callback here
                callbackContext.success(inAppStatus.toString());
            }
        });
    }

    public void showInAppNotificatonWithCustomAttributes(int messageType, String navigationBarColor, final CallbackContext callbackContext) {
        Pyze.showInAppNotificationUI((Activity)webView.getContext(), Constants.PyzeInAppMessageType.values()[messageType], navigationBarColor, new InAppNotificationTemplateDialogFragment.OnButtonClickListener() {
            @Override
            public void onButtonClicked(Pyze.InAppStatus inAppStatus) {
                //Invoke callback here
                callbackContext.success(inAppStatus.toString());
            }
        });
    }

    
    public void closeInAppMessage() {
        Pyze.closeInAppMessageDialog((Activity)webView.getContext());
    }

    
    public void countNewUnFetchedMessages(final CallbackContext callback) {
        Pyze.countNewUnFetched(new PyzeInAppMessagesManager.GetMessageCountListener() {
            @Override
            public void onUnreadMessageCountDownloaded(int i) {
                callback.success(i);
            }
        });
    }

    
    public void getMessageHeaderOfType(int messageType, final CallbackContext callback) {
        Pyze.getMessageHeadersForType(Constants.PyzeInAppMessageType.values()[messageType], new PyzeInAppMessagesManager.GetMetadataListener() {
            @Override
            public void onMetadataReceived(MetadataList metadataList) {
                String value = "[";
                int metaDataListLength = metadataList.size();
                for(int messageHeaderIndex = 0; messageHeaderIndex<metaDataListLength;messageHeaderIndex++){
                    Metadata metadata = metadataList.get(messageHeaderIndex);
                    value+="{\"cid\":\""+metadata.cid+"\",\"contentRead\":\""+metadata.isRead+"\",\"mid\":\""+metadata.mid+"\",\"title\":\""+metadata.title+"\"}";
                    if(messageHeaderIndex < metaDataListLength-1){
                        value +=",";
                    }
                }
                callback.success(value + "]");
            }
        });
    }

    
    public void getMessageWithContentID(String contentId, String messageId, final CallbackContext callback) {
        Pyze.getMessageWithContentID(messageId, contentId, new PyzeInAppMessagesManager.GetMessageListener() {
            @Override
            public void onMessageDownloaded(Message message) {
                JSONObject response = new JSONObject();
                try {
                    JSONObject payload = new JSONObject();
                    payload.put("title", message.title);
                    payload.put("msg", message.body);
                    payload.put("templateId", message.templateId);
                    JSONObject templateData = new JSONObject();
                    templateData.put("titleColor", message.templateData.titleColor);
                    templateData.put("msgColor", message.templateData.msgColor);

                    JSONArray buttons = new JSONArray();
                    for (Button button : message.templateData.buttons) {
                        JSONArray jsonButton = new JSONArray();
                        jsonButton.put(0, button.title);
                        jsonButton.put(1, button.action);
                        jsonButton.put(2, button.backgroundColor);
                        jsonButton.put(3, button.titleColor);
                        buttons.put(jsonButton);
                    }
                    templateData.put("buttons", buttons);
                    payload.put("templateData", templateData);
                    response.put("payload", payload);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callback.success(response.toString());
            }
        });

    }

    /***
     * End Region PyzeInAppMessages
     ***/

    /***
     Region PyzeIdentity
     ***/

    
    public void  setUserIdentifier(String userId){
        PyzeIdentity.setUserIdentifer(userId);
    }

    
    public void  resetUserIdentifier(){
        PyzeIdentity.resetUserIdentifer();
    }

    
    public void  postTraits  (String attirbutes){
        PyzeIdentity.postTraits(stringToHashMap(attirbutes));
    }

    /***
     End Region PyzeIdentity
     ***/


    /***
     * Region PyzeSceneFlow
     ***/
    
    public void postSecondsOnScene(String sceneName, float seconds) {
        PyzeSceneFlow.secondsOnScene(sceneName,seconds);
    }

    /***
     * End Region PyzeSceneFlow
     ***/

    /***
     * Region PyzePersonalizationIntelligence
     ***/

    public void getTags(final CallbackContext callback) {
        PyzePersonalizationIntelligence.getTags(new TagsManager.OnRequestTagsListener() {
            @Override
            public void onTagsRequested(HashSet<String> hashSet) {
                callback.success(hashSet.toString());
            }
        });
    }

    public void isTagSet(String tag, CallbackContext callback) {
         callback.success(PyzePersonalizationIntelligence.isTagSet(tag)?1:0);
    }

    
    public void areAnyTagSet(String tags, CallbackContext callback) {
        callback.success(PyzePersonalizationIntelligence.areAnyTagsSet(tags.split(","))?1:0);
    }

    
    public void areAllTagSet(String tags, CallbackContext callback) {
       callback.success(PyzePersonalizationIntelligence.areAllTagsSet(tags.split(","))?1:0);
    }

    /***
     * End Region PyzePersonalizationIntelligence
     ***/


    public static HashMap<String,String> stringToHashMap(String mapString){
        HashMap<String,String> map = new HashMap<String,String>();
        try {
            JSONObject mapObject = new JSONObject(mapString);
            Iterator<String> keys= mapObject.keys();
            while (keys.hasNext()){
                String key   =  keys.next();
                String value = mapObject.getString(key);
                map.put(key,value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }
    public static PyzeGeoPoint stringToPyzeGeoPoint(String pointString){
        PyzeGeoPoint pyzeGeoPoint = new PyzeGeoPoint();
        try {
            JSONObject pointObj = new JSONObject(pointString);
            pyzeGeoPoint.mLatitude  = (float) pointObj.getDouble("lat");
            pyzeGeoPoint.mLongitude = (float) pointObj.getDouble("lng");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return pyzeGeoPoint;
    }
}