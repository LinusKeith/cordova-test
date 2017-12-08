var exec = require('cordova/exec');

exports.cordova = {
    test: function (arg0, success, error) {
        exec(success, error, "PyzeCordova", "echo", [arg0]);
        success(arg0);
    },
    PyzeEvents: {
        postCustomEvent: function (eventName) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCustomEvent", [eventName]);
        },
        postCustomEventWithAttributes: function (eventName, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCustomEventWithAttributes", [eventName, JSON.stringify(customAttributes)]);
        },
        postTimedEventWithName: function (eventName, timerReference) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTimedEventWithName", [eventName, timerReference]);
        },
        postTimedEventWithNameAndAttributes: function (eventName, timerReference, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTimedEventWithNameAndAttributes", [eventName, timerReference, JSON.stringify(customAttributes)]);
        }
    },
    Pyze: {
        // initialize: function () {},
        // initializeWithLogLevel: function (logLevel) {},
        getTimerReference: function () {

        },
        showInAppNotification: function (callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "showInAppNotification", []);
        },
        showInAppNotificatonWithCustomAttributes: function (messageType, navigationBarColor, callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "showInAppNotificatonWithCustomAttributes", [messageType, navigationBarColor]);
        },
        closeInAppMessage: function () {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "closeInAppMessage", []);
        },
        countNewUnFetchedMessages: function (callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "countNewUnFetchedMessages", []);
        },
        getMessageHeaderOfType: function (messageType, callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "getMessageHeaderOfType", [messageType]);
        },
        getMessageWithContentID: function (cId, mId, callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "getMessageWithContentID", [cId, mId]);
        },
    },
    PyzeAccount: {
        postLoginOffered: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLoginOffered", [JSON.stringify(customAttributes)]);
        },
        postLoginStarted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLoginStarted", [JSON.stringify(customAttributes)]);
        },
        postSocialLoginOffered: function (type, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSocialLoginOffered", [type, JSON.stringify(customAttributes)]);
        },
        postSocialLoginStarted: function (type, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSocialLoginStarted", [type, JSON.stringify(customAttributes)]);
        },
        postSocialLoginCompleted: function (type, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSocialLoginCompleted", [type, JSON.stringify(customAttributes)]);
        },
        postRegistrationOffered: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRegistrationOffered", [JSON.stringify(customAttributes)]);
        },
        postRegistrationStarted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRegistrationStarted", [JSON.stringify(customAttributes)]);
        },
        postRegistrationCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRegistrationCompleted", [JSON.stringify(customAttributes)]);
        },
        postLoginCompleted: function (success, errCodeStr, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLoginCompleted", [success, errCodeStr, JSON.stringify(customAttributes)]);
        },
        postLogoutCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLogoutCompleted", [JSON.stringify(customAttributes)]);
        },
        postPasswordResetRequest: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPasswordResetRequest", [JSON.stringify(customAttributes)]);
        },
        postPasswordResetCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPasswordResetCompleted", [JSON.stringify(customAttributes)]);
        }
    },
    PyzeAd: {
        postAdRequested: function (adNetwork, appScreen, size, type, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAdRequested", [adNetwork, appScreen, size, type, JSON.stringify(customAttributes)]);
        },
        postAdReceived: function (adNetwork, appScreen, resultCode, success, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAdReceived", [adNetwork, appScreen, resultCode, success, JSON.stringify(customAttributes)]);
        },
        postAdClicked: function (adNetwork, appScreen, adCode, success, errorCode, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAdClicked", [adNetwork, appScreen, adCode, success, errorCode, JSON.stringify(customAttributes)]);
        },
    },
    PyzeAdvocacy: {
        postRequestFeedback: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRequestFeedback", [JSON.stringify(customAttributes)]);
        },
        postFeedbackProvided: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFeedbackProvided", [JSON.stringify(customAttributes)]);
        },
        postRequestRating: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRequestRating", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeBitcoin: {
        postSentBitCoins: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSentBitCoins", [JSON.stringify(customAttributes)]);
        },
        postRequestedBitCoins: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRequestedBitCoins", [JSON.stringify(customAttributes)]);
        },
        postReceivedBitCoins: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postReceivedBitCoins", [JSON.stringify(customAttributes)]);
        },
        postViewedTransaction: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postViewedTransaction", [JSON.stringify(customAttributes)]);
        },
        postImportedPrivateKey: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postImportedPrivateKey", [JSON.stringify(customAttributes)]);
        },
        postScannedPrivateKey: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postScannedPrivateKey", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceBeacon: {
        postEnteredRegion: function (beaconUUID, beaconMajor, beaconMinor, uniqueRegionIdentifier, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postEnteredRegion", [beaconUUID, beaconMajor, beaconMinor, uniqueRegionIdentifier, JSON.stringify(customAttributes)]);
        },
        postExitedRegion: function (beaconUUID, beaconMajor, beaconMinor, uniqueRegionIdentifier, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postExitedRegion", [beaconUUID, beaconMajor, beaconMinor, uniqueRegionIdentifier, JSON.stringify(customAttributes)]);
        },
        postTransactedRegion: function (beaconUUID, beaconMajor, beaconMinor, uniqueRegionIdentifier, proximity, actionId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTransactedRegion", [beaconUUID, beaconMajor, beaconMinor, uniqueRegionIdentifier, proximity, actionId, JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceBilling: {
        postBillingStarted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBillingStarted", [JSON.stringify(customAttributes)]);
        },
        postBillingCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBillingCompleted", [JSON.stringify(customAttributes)]);
        },
        postBillingAbandoned: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBillingAbandoned", [JSON.stringify(customAttributes)]);
        },
        postBillingFailed: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBillingFailed", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceCart: {
        postAddItem: function (cartId, itemCategory, itemId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItem", [cartId, itemCategory, itemId, JSON.stringify(customAttributes)]);
        },
        postAddItemFromDeals: function (cartId, itemCategory, itemId, uniqueDealId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItemFromDeals", [cartId, itemCategory, itemId, uniqueDealId, JSON.stringify(customAttributes)]);
        },
        postAddItemFromWishList: function (cartId, itemCategory, itemId, uniqueWishListId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItemFromWishList", [cartId, itemCategory, itemId, uniqueWishListId, JSON.stringify(customAttributes)]);
        },
        postAddItemFromCuratedList: function (cartId, itemCategory, itemId, uniqueCuratedListID, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItemFromCuratedList", [cartId, itemCategory, itemId, uniqueCuratedListID, JSON.stringify(customAttributes)]);
        },
        postAddItemFromRecommendations: function (cartId, itemCategory, itemId, uniqueRecommendationId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItemFromRecommendations", [cartId, itemCategory, itemId, uniqueRecommendationId, JSON.stringify(customAttributes)]);
        },
        postAddItemFromPreviousOrders: function (cartId, itemCategory, itemId, previousOrderId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItemFromPreviousOrders", [cartId, itemCategory, itemId, previousOrderId, JSON.stringify(customAttributes)]);
        },
        postAddItemFromSearchResults: function (cartId, itemCategory, itemId, searchstring, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItemFromSearchResults", [cartId, itemCategory, itemId, searchstring, JSON.stringify(customAttributes)]);
        },
        postAddItemFromSubscriptionList: function (cartId, itemCategory, itemId, uniqueSubscriptionId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddItemFromSubscriptionList", [cartId, itemCategory, itemId, uniqueSubscriptionId, JSON.stringify(customAttributes)]);
        },
        postRemoveItemFromCart: function (cartId, itemCategory, itemId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRemoveItemFromCart", [cartId, itemCategory, itemId, JSON.stringify(customAttributes)]);
        },
        postShare: function (cartId, sharedWith, itemId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postShare", [cartId, sharedWith, itemId, JSON.stringify(customAttributes)]);
        },
        postView: function (cartId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postView", [cartId, JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceCheckout: {
        postCheckoutStarted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCheckoutStarted", [JSON.stringify(customAttributes)]);
        },
        postCheckoutCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCheckoutCompleted", [JSON.stringify(customAttributes)]);
        },
        postCheckoutAbandoned: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCheckoutAbandoned", [JSON.stringify(customAttributes)]);
        },
        postCheckoutFailed: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCheckoutFailed", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceCuratedList: {
        postCreated: function (uniqueCuratedListID, curatedListType, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCreated", [uniqueCuratedListID, curatedListType, JSON.stringify(customAttributes)]);
        },
        postBrowsed: function (curatedList, curatedListCreator, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBrowsed", [curatedList, curatedListCreator, JSON.stringify(customAttributes)]);
        },
        postAddedItem: function (uniqueCuratedListID, itemCategory, itemId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddedItem", [uniqueCuratedListID, itemCategory, itemId, JSON.stringify(customAttributes)]);
        },
        postRemovedItem: function (uniqueCuratedListID, curatedListType, itemId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRemovedItem", [uniqueCuratedListID, curatedListType, itemId, JSON.stringify(customAttributes)]);
        },
        postShared: function (curatedList, curatedListCreator, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postShared", [curatedList, curatedListCreator, JSON.stringify(customAttributes)]);
        },
        postPublished: function (curatedList, curatedListCreator, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPublished", [curatedList, curatedListCreator, JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceDiscovery: {
        pyzeCommerceDiscoveryPostSearched: function (searchstring, latency, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "pyzeCommerceDiscoveryPostSearched", [searchstring, latency, JSON.stringify(customAttributes)]);
        },
        postBrowsedCategory: function (category, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBrowsedCategory", [category, JSON.stringify(customAttributes)]);
        },
        postBrowsedDeals: function (uniqueDealId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBrowsedDeals", [uniqueDealId, JSON.stringify(customAttributes)]);
        },
        postBrowsedRecommendations: function (uniqueRecommendationID, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBrowsedRecommendations", [uniqueRecommendationID, JSON.stringify(customAttributes)]);
        },
        postBrowsedPrevOrders: function (rangeStart, rangeEnd, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBrowsedPrevOrders", [rangeStart, rangeEnd, SON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceItem: {
        postViewedItem: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postViewedItem", [JSON.stringify(customAttributes)]);
        },
        postScannedItem: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postScannedItem", [JSON.stringify(customAttributes)]);
        },
        postViewedReviews: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postViewedReviews", [JSON.stringify(customAttributes)]);
        },
        postViewedDetails: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postViewedDetails", [JSON.stringify(customAttributes)]);
        },
        postViewedPrice: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postViewedPrice", [JSON.stringify(customAttributes)]);
        },
        postItemShare: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postItemShare", [JSON.stringify(customAttributes)]);
        },
        postItemRateOn5Scale: function (itemSKU, rating, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postItemRateOn5Scale", [itemSKU, rating, JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommercePayment: {
        postPaymentStarted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPaymentStarted", [JSON.stringify(customAttributes)]);
        },
        postPaymentCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPaymentCompleted", [JSON.stringify(customAttributes)]);
        },
        postPaymentAbandoned: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPaymentAbandoned", [JSON.stringify(customAttributes)]);
        },
        postPaymentFailed: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPaymentFailed", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceRevenue: {
        postRevenue: function (revenue, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRevenue", [revenue, JSON.stringify(customAttributes)]);
        },
        postRevenueDetailed: function (revenue, paymentInstrument, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRevenueDetailed", [revenue, paymentInstrument,  JSON.stringify(customAttributes)]);
        },
        postRevenueUsingApplePay: function (revenue, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRevenueUsingApplePay", [revenue, JSON.stringify(customAttributes)]);
        },
        postRevenueUsingSamsungPay: function (revenue, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRevenueUsingSamsungPay", [revenue, JSON.stringify(customAttributes)]);
        },
        postRevenueUsingGooglePay: function (revenue, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRevenueUsingGooglePay", [revenue, JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceShipping: {
        postShippingStarted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postShippingStarted", [JSON.stringify(customAttributes)]);
        },
        postShippingCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postShippingCompleted", [JSON.stringify(customAttributes)]);
        },
        postShippingAbandoned: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postShippingAbandoned", [JSON.stringify(customAttributes)]);
        },
        postShippingFailed: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postShippingFailed", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceSupport: {
        postLiveChatStartedWithTopic: function (topic, orderNumber, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLiveChatStartedWithTopic", [topic, orderNumber, JSON.stringify(customAttributes)]);
        },
        postLiveChatEndedWithTopic: function (topic, orderNumber, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLiveChatEndedWithTopic", [topic, orderNumber, JSON.stringify(customAttributes)]);
        },
        postTicketCreated: function (topic, itemID, orderNumber, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTicketCreated", [topic, itemID, orderNumber, JSON.stringify(customAttributes)]);
        },
        postFeedbackReceived: function (feedback, orderNumber, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFeedbackReceived", [feedback, orderNumber, JSON.stringify(customAttributes)]);
        },
        postQualityOfServiceRated: function (comment, rating, orderNumber, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postQualityOfServiceRated", [comment, rating, orderNumber, JSON.stringify(customAttributes)]);
        },
    },
    PyzeCommerceWishList: {
        postCreated: function (uniqueWishListId, wishListType, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postCreated", [uniqueWishListId, wishListType, JSON.stringify(customAttributes)]);
        },
        postBrowsed: function (uniqueWishListId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBrowsed", [uniqueWishListId, JSON.stringify(customAttributes)]);
        },
        postAddedItem: function (uniqueWishListId, itemCategory, itemId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddedItem", [uniqueWishListId, itemCategory, itemId, JSON.stringify(customAttributes)]);
        },
        postRemovedItem: function (uniqueWishListId, itemCategory, itemId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRemovedItem", [uniqueWishListId, itemCategory, itemId, JSON.stringify(customAttributes)]);
        },
        postShared: function (uniqueWishListId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postShared", [uniqueWishListId, JSON.stringify(customAttributes)]);
        },
    },
    PyzeContent: {
        postViewed: function (contentName, categoryName, contentId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postViewed", [contentName, categoryName, contentId, JSON.stringify(customAttributes)]);
        },
        postSearched: function (searchstring, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSearched", [searchstring, JSON.stringify(customAttributes)]);
        },
        postRatedOn5PointScale: function (contentName, categoryName, contentId, rating, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRatedOn5PointScale", [contentName, categoryName, contentId, rating, JSON.stringify(customAttributes)]);
        },
        postRatedThumbsUp: function (contentName, categoryName, contentId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRatedThumbsUp", [contentName, categoryName, contentId, JSON.stringify(customAttributes)]);
        },
        postRatedThumbsDown: function (contentName, categoryName, contentId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRatedThumbsDown", [contentName, categoryName, contentId, JSON.stringify(customAttributes)]);
        },
    },
    PyzeDrone: {
        postPreflightCheckCompleted: function (overallStatus, storageStatus, droneBatteryChargePercent, deviceBatteryChargePercent, calibrationStatus, gpsStatus, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPreflightCheckCompleted", [overallStatus, storageStatus, droneBatteryChargePercent, deviceBatteryChargePercent, calibrationStatus, gpsStatus, JSON.stringify(customAttributes)]);
        },
        postInflightCheckCompleted: function (overallStatus, rollStatus, pitchStatus, yawStatus, throttleStatus, trimmingSettings, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postInflightCheckCompleted", [overallStatus, rollStatus, pitchStatus, yawStatus, throttleStatus, trimmingSettings, JSON.stringify(customAttributes)]);
        },
        postConnected: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postConnected", [JSON.stringify(customAttributes)]);
        },
        postDisconnected: function (code, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postDisconnected", [code, JSON.stringify(customAttributes)]);
        },
        postAirborne: function (status, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAirborne", [status, JSON.stringify(customAttributes)]);
        },
        postLanded: function (status, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLanded", [status, JSON.stringify(customAttributes)]);
        },
        postFlightPathCreated: function (uniqueFlightPathId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFlightPathCreated", [uniqueFlightPathId, JSON.stringify(customAttributes)]);
        },
        postFlightPathUploaded: function (uniqueFlightPathId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFlightPathUploaded", [uniqueFlightPathId, JSON.stringify(customAttributes)]);
        },
        postFlightPathEdited: function (uniqueFlightPathId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFlightPathEdited", [uniqueFlightPathId, JSON.stringify(customAttributes)]);
        },
        postFlightPathDeleted: function (uniqueFlightPathId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFlightPathDeleted", [uniqueFlightPathId, JSON.stringify(customAttributes)]);
        },
        postFlightPathCompleted: function (uniqueFlightPathId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFlightPathCompleted", [uniqueFlightPathId, JSON.stringify(customAttributes)]);
        },
        postFirstPersonViewEnabled: function (status, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFirstPersonViewEnabled", [status, JSON.stringify(customAttributes)]);
        },
        postFirstPersonViewDisabled: function (status, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFirstPersonViewDisabled", [status, JSON.stringify(customAttributes)]);
        },
        postStartedAerialVideo: function (status, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postStartedAerialVideo", [status, JSON.stringify(customAttributes)]);
        },
        postStartedAerialVideoDetailed: function (status, videoIdentifer, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postStartedAerialVideoDetailed", [status, videoIdentifer, JSON.stringify(customAttributes)]);
        },
        postStoppedAerialVideo: function (status, secondsLength, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postStoppedAerialVideo", [status, secondsLength, JSON.stringify(customAttributes)]);
        },
        postTookAerialPicture: function (status, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTookAerialPicture", [status, JSON.stringify(customAttributes)]);
        },
        postStartedAerialTimelapse: function (status, totalshots, secondsBetweenShots, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postStartedAerialTimelapse", [status, totalshots, secondsBetweenShots, JSON.stringify(customAttributes)]);
        },
        postStoppedAerialTimelapse: function (status, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postStoppedAerialTimelapse", [status, JSON.stringify(customAttributes)]);
        },
        postRequestedReturnToBase: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRequestedReturnToBase", [JSON.stringify(customAttributes)]);
        },
        postSwitchedToHelicopterFlyingMode: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSwitchedToHelicopterFlyingMode", [JSON.stringify(customAttributes)]);
        },
        postSwitchedToAltitudeFlyingMode: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSwitchedToAltitudeFlyingMode", [JSON.stringify(customAttributes)]);
        },
        postSwitchedToGPSHoldFlyingMode: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSwitchedToGPSHoldFlyingMode", [JSON.stringify(customAttributes)]);
        },
        postSwitchedToCustomFlyingMode: function (mode, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSwitchedToCustomFlyingMode", [JSON.stringify(customAttributes)]);
        },
        postSetMaxAltitude: function (altitudeInMeters, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSetMaxAltitude", [mode, JSON.stringify(customAttributes)]);
        },
        postSetAutoReturnInSeconds: function (seconds, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSetAutoReturnInSeconds", [seconds, JSON.stringify(customAttributes)]);
        },
        postSetAutoReturnWhenLowMemory: function (memoryLeftInKilobytes, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSetAutoReturnWhenLowMemory", [memoryLeftInKilobytes, JSON.stringify(customAttributes)]);
        },
        postSetAutoReturnWhenLowBattery: function (batterylevelPercent, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSetAutoReturnWhenLowBattery", [batterylevelPercent, JSON.stringify(customAttributes)]);
        },
    },
    PyzeExplicitActivation: {
        postWithAttributes: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWithAttributes", [JSON.stringify(customAttributes)]);
        },
        post: function () {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "post", []);
        },
    },
    PyzeGaming: {
        postLevelStarted: function (level, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLevelStarted", [level, JSON.stringify(customAttributes)]);
        },
        postLevelEnded: function (level, score, success, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLevelEnded", [level, score, success, JSON.stringify(customAttributes)]);
        },
        postPowerUpConsumed: function (level, type, value, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPowerUpConsumed", [level, type, value, JSON.stringify(customAttributes)]);
        },
        postInGameItemPurchased: function (uniqueItemId, itemType, value, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postInGameItemPurchased", [uniqueItemId, itemType, value, JSON.stringify(customAttributes)]);
        },
        postAchievementEarned: function (uniqueAchievementId, type, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAchievementEarned", [uniqueAchievementId, type, JSON.stringify(customAttributes)]);
        },
        postSummaryViewed: function (level, type, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSummaryViewed", [level, type, JSON.stringify(customAttributes)]);
        },
        postLeaderBoardViewed: function (level, score, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLeaderBoardViewed", [level, score, JSON.stringify(customAttributes)]);
        },
        postScorecardViewed: function (level, score, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postScorecardViewed", [level, score, JSON.stringify(customAttributes)]);
        },
        postHelpViewed: function (helpTopicId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postHelpViewed", [helpTopicId, JSON.stringify(customAttributes)]);
        },
        postTutorialViewed: function (helpTopicId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTutorialViewed", [helpTopicId, JSON.stringify(customAttributes)]);
        },
        postFriendChallenged: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFriendChallenged", [JSON.stringify(customAttributes)]);
        },
        postChallengeAccepted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postChallengeAccepted", [JSON.stringify(customAttributes)]);
        },
        postChallengeDeclined: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postChallengeDeclined", [JSON.stringify(customAttributes)]);
        },
        postGameStarted: function (level, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postGameStarted", [level, JSON.stringify(customAttributes)]);
        },
        postGameEnd: function (levelsPlayed, levelsWon, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postGameEnd", [levelsPlayed, levelsWon, JSON.stringify(customAttributes)]);
        },
    },
    PyzeHealthAndFitness: {
        postStarted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postStarted", [JSON.stringify(customAttributes)]);
        },
        postEnded: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postEnded", [JSON.stringify(customAttributes)]);
        },
        postAchievementReceived: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAchievementReceived", [JSON.stringify(customAttributes)]);
        },
        postStepGoalCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postStepGoalCompleted", [JSON.stringify(customAttributes)]);
        },
        postGoalCompleted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postGoalCompleted", [JSON.stringify(customAttributes)]);
        },
        postChallengedFriend: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postChallengedFriend", [JSON.stringify(customAttributes)]);
        },
        pyzeHealthAndFitnessPostChallengeAccepted: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "pyzeHealthAndFitnessPostChallengeAccepted", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeIdentity: {
        setUserIdentifier: function (userIdentifier) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "setUserIdentifier", [userIdentifier]);
        },
        resetUserIdentifier: function () {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "resetUserIdentifier", []);
        },
        postTraits: function (attributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTraits", [JSON.stringify(attributes)]);
        },
    },
    PyzeInAppPurchaseRevenue: {
        postPriceListViewed: function (appScreenRequestFromId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postPriceListViewed", [appScreenRequestFromId, JSON.stringify(customAttributes)]);
        },
        postBuyItem: function (itemName, currency, price, itemType, itemSKU, quantity, appScreenRequestFromId, status, successOrErrorCode, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBuyItem", [itemName, currency, price, itemType, itemSKU, quantity, appScreenRequestFromId, status, successOrErrorCode, JSON.stringify(customAttributes)]);
        },
        postBuyItemShort: function (itemName, price, currencyISO4217Code, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBuyItemShort", [itemName, price, currencyISO4217Code, JSON.stringify(customAttributes)]);
        },
        postBuyItemUSD: function (itemName, price, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postBuyItemUSD", [itemName, price, JSON.stringify(customAttributes)]);
        },
    },
    PyzeMedia: {
        pyzeMediaPostPlayedMedia: function (contentName, type, categoryName, percent, contentId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "pyzeMediaPostPlayedMedia", [contentName, type, categoryName, percent, contentId, JSON.stringify(customAttributes)]);
        },
        pyzeMediaPostSearched: function (searchString, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "pyzeMediaPostSearched", [searchString, JSON.stringify(customAttributes)]);
        },
        postRateOn5PointScale: function (contentName, categoryName, contentId, rating, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRateOn5PointScale", [contentName, categoryName, contentId, rating, JSON.stringify(customAttributes)]);
        },
        pyzeMediaPostRatedThumbsUp: function (contentName, categoryName, contentId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "pyzeMediaPostRatedThumbsUp", [contentName, categoryName, contentId, JSON.stringify(customAttributes)]);
        },
        pyzeMediaPostRatedThumbsDown: function (contentName, categoryName, contentId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "pyzeMediaPostRatedThumbsDown", [contentName, categoryName, contentId, JSON.stringify(customAttributes)]);
        },
    },
    PyzeMessaging: {
        postMessageSent: function (uniqueId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postMessageSent", [uniqueId, JSON.stringify(customAttributes)]);
        },
        postMessageSentOfType: function (messageType, uniqueId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postMessageSentOfType", [messageType, uniqueId, JSON.stringify(customAttributes)]);
        },
        postMessageReceived: function (uniqueId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postMessageReceived", [uniqueId, JSON.stringify(customAttributes)]);
        },
        postMessageNewConversation: function (uniqueId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postMessageNewConversation", [uniqueId, JSON.stringify(customAttributes)]);
        },
        postMessageVoiceCall: function (uniqueId, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postMessageVoiceCall", [uniqueId, JSON.stringify(customAttributes)]);
        },
    },
    PyzePersonalizationIntelligence: {
        getTags: function (callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "getTags", []);
        },
        isTagSet: function (tag, callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "isTagSet", [tag]);
        },
        areAnyTagSet: function (tags, callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "areAnyTagSet", [tags]);
        },
        areAllTagSet: function (tags, callback) {
            exec(function (successParam) {
                callback(successParam)
            }, function (successParam) {}, "PyzeCordova", "areAllTagSet", [tags]);
        },
    },
    PyzeSceneFlow: {
        postSecondsOnScene: function (sceneName, seconds) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSecondsOnScene", [sceneName, seconds]);
        },
    },
    PyzeSocial: {
        postSocialContentShareForNetworkName: function (socialNetworkName, contentReference, category, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSocialContentShareForNetworkName", [socialNetworkName, contentReference, category, JSON.stringify(customAttributes)]);
        },
        postLiked: function (socialNetworkName, contentReference, category, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLiked", [socialNetworkName, contentReference, category, JSON.stringify(customAttributes)]);
        },
        postFollowed: function (socialNetworkName, contentReference, category, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFollowed", [socialNetworkName, contentReference, category, JSON.stringify(customAttributes)]);
        },
        postSubscribed: function (socialNetworkName, contentReference, category, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postSubscribed", [socialNetworkName, contentReference, category, JSON.stringify(customAttributes)]);
        },
        postInvitedFriends: function (socialNetworkName, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postInvitedFriends", [socialNetworkName, JSON.stringify(customAttributes)]);
        },
        postFoundFriends: function (source, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFoundFriends", [source, JSON.stringify(customAttributes)]);
        },
    },
    PyzeSupport: {
        postRequestedPhoneCallback: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postRequestedPhoneCallback", [JSON.stringify(customAttributes)]);
        },
        postLiveChatStartedWithTopic: function (topic, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLiveChatStartedWithTopic", [topic, JSON.stringify(customAttributes)]);
        },
        postLiveChatEndedWithTopic: function (topic, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postLiveChatEndedWithTopic", [topic, JSON.stringify(customAttributes)]);
        },
        postTicketCreated: function (itemID, topic, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postTicketCreated", [itemID, topic, JSON.stringify(customAttributes)]);
        },
        postFeedbackReceived: function (feedback, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postFeedbackReceived", [feedback, JSON.stringify(customAttributes)]);
        },
        postQualityOfServiceRated: function (comment, rating, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postQualityOfServiceRated", [comment, rating, JSON.stringify(customAttributes)]);
        },
    },
    PyzeTasks: {
        postAddToCalendarWithAttributes: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postAddToCalendarWithAttributes", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeWeatherAndForecast: {
        postWeatherRequestedForType: function (type, howManyDays, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherRequestedForType", [type, howManyDays, JSON.stringify(customAttributes)]);
        },
        postWeatherHistoricalRequest: function (startInterval, endInterval, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherHistoricalRequest", [startInterval, endInterval, JSON.stringify(customAttributes)]);
        },
        postWeatherStationsRequestWithClusterData: function (clusterData, point, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherStationsRequestWithClusterData", [clusterData, JSON.stringify(point), JSON.stringify(customAttributes)]);
        },
        postWeatherMapLayersRequested: function (layerName, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherMapLayersRequested", [layerName, JSON.stringify(customAttributes)]);
        },
        postWeatherRequestForUVIndexAtPoint: function (point, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherRequestForUVIndexAtPoint", [JSON.stringify(point), JSON.stringify(customAttributes)]);
        },
        postWeatherResponseForType: function (type, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherResponseForType", [type, JSON.stringify(customAttributes)]);
        },
        postWeatherResponseForHistoricalData: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherResponseForHistoricalData", [JSON.stringify(customAttributes)]);
        },
        postWeatherStationResponseData: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherStationResponseData", [JSON.stringify(customAttributes)]);
        },
        postWeatherMapLayersResponse: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherMapLayersResponse", [JSON.stringify(customAttributes)]);
        },
        postWeatherResponseForUVIndex: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postWeatherResponseForUVIndex", [JSON.stringify(customAttributes)]);
        },
        postForecastRequestForKeywords: function (commaSeperateKeywords, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postForecastRequestForKeywords", [commaSeperateKeywords, JSON.stringify(customAttributes)]);
        },
        postForecastResponseForKeywordsShort: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postForecastResponseForKeywordsShort", [JSON.stringify(customAttributes)]);
        },
        postForecastFetch: function (nDays, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postForecastFetch", [nDays, JSON.stringify(customAttributes)]);
        },
        postForecastFetchResponse: function (customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "postForecastFetchResponse", [JSON.stringify(customAttributes)]);
        },
    },
    PyzeSMS: {
        registerDevice: function (phoneNumber, countryCode, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "registerDevice", [phoneNumber, countryCode, JSON.stringify(customAttributes)]);
        },
        sendVerification: function (phoneNumber, countryCode, verificationCode, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "sendVerification", [phoneNumber, countryCode, verificationCode, JSON.stringify(customAttributes)]);
        },
        unsubscribeDevice: function (phoneNumber, countryCode, customAttributes) {
            exec(function (successParam) {}, function (successParam) {}, "PyzeCordova", "unsubscribeDevice", [phoneNumber, countryCode, JSON.stringify(customAttributes)]);
        },
    }
}