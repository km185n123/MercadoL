package com.example.ecommerce.data.articles.datasourse.apiservice.model

import com.google.gson.annotations.SerializedName


data class ArticlesResponse (
    @SerializedName( "site_id")
    val siteID: SiteID,
    @SerializedName( "country_default_time_zone")
    val countryDefaultTimeZone: String,
    val query: String,
    val paging: Paging,
    @SerializedName( "results")
    val articles: List<Article>,
    val sort: Sort,
    @SerializedName("available_sorts")
    val availableSorts: List<Sort>,
    val filters: List<Filter>,
    @SerializedName( "available_filters")
    val availableFilters: List<AvailableFilter>
)

data class AvailableFilter (
    val id: String,
    val name: String,
    val type: String,
    val values: List<AvailableFilterValue>
)

data class AvailableFilterValue (
    val id: String,
    val name: String,
    val results: Long
)

data class Sort (
    val id: String,
    val name: String
)

data class Filter (
    val id: String,
    val name: String,
    val type: String,
    val values: List<FilterValue>
)

data class FilterValue (
    val id: String,
    val name: String,
    @SerializedName("path_from_root")
    val pathFromRoot: List<Sort>
)

data class Paging (
    val total: Long,
    @SerializedName("primary_results")
    val primaryResults: Long,
    val offset: Long,
    val limit: Long
)

data class Article ( var id: String, var title: String) {


    @SerializedName("site_id")
    lateinit var siteID: SiteID

    lateinit var seller: Seller
    var price: Long = 0
    lateinit var prices: Prices

    @SerializedName("sale_price")
    var salePrice: Any? = null

    @SerializedName("currency_id")
    lateinit var currencyID: CurrencyID

    @SerializedName("available_quantity")
    var availableQuantity: Long = 0

    @SerializedName("sold_quantity")
    var soldQuantity: Long = 0

    @SerializedName("buying_mode")
    lateinit var buyingMode: BuyingMode

    @SerializedName("listing_type_id")
    lateinit var listingTypeID: ListingTypeID

    @SerializedName("stop_time")
    lateinit var stopTime: String
    lateinit var condition: Condition
    lateinit var permalink: String
    lateinit var thumbnail: String

    @SerializedName("thumbnail_id")
    lateinit var thumbnailID: String

    @SerializedName("accepts_mercadopago")
    var acceptsMercadopago: Boolean = false
    lateinit var installments: Installments
    lateinit var address: Address
    lateinit var shipping: Shipping

    @SerializedName("seller_address")
    lateinit var sellerAddress: SellerAddress
    lateinit var attributes: List<Attribute>

    @SerializedName("original_price")
    var originalPrice: Long? = null

    @SerializedName("category_id")
    lateinit var categoryID: String

    @SerializedName("official_store_id")
    var officialStoreID: Long? = null

    @SerializedName("domain_id")
    lateinit var domainID: DomainID

    @SerializedName("catalog_product_id")
    var catalogProductID: String? = null
    lateinit var tags: List<ResultTag>

    @SerializedName("catalog_listing")
    var catalogListing: Boolean? = null

    @SerializedName("use_thumbnail_id")
    var useThumbnailID: Boolean = false

    @SerializedName("offer_score")
    var offerScore: Any? = null

    @SerializedName("offer_share")
    var offerShare: Any? = null

    @SerializedName("match_score")
    var matchScore: Any? = null

    @SerializedName("winner_item_id")
    var winnerItemID: Any? = null
    var melicoin: Any? = null
    var discounts: Any? = null

    @SerializedName("order_backend")
    var orderBackend: Long = 0

    @SerializedName("differential_pricing")
    var differentialPricing: DifferentialPricing? = null
}

data class Address (
    @SerializedName("state_id")
    val stateID: StateID,

    @SerializedName("state_name")
    val stateName: StateName,

    @SerializedName("city_id")
    val cityID: String,

    @SerializedName("city_name")
    val cityName: String
)

enum class StateID(val value: String) {
    CoCun("CO-CUN"),
    CoDc("CO-DC"),
    CoSAN("CO-SAN"),
    CoVac("CO-VAC");

    companion object {
        public fun fromValue(value: String): StateID = when (value) {
            "CO-CUN" -> CoCun
            "CO-DC"  -> CoDc
            "CO-SAN" -> CoSAN
            "CO-VAC" -> CoVac
            else     -> throw IllegalArgumentException()
        }
    }
}

enum class StateName(val value: String) {
    BogotáDC("Bogotá D.C."),
    Cundinamarca("Cundinamarca"),
    Santander("Santander"),
    ValleDelCauca("Valle Del Cauca");

    companion object {
        public fun fromValue(value: String): StateName = when (value) {
            "Bogotá D.C."     -> BogotáDC
            "Cundinamarca"    -> Cundinamarca
            "Santander"       -> Santander
            "Valle Del Cauca" -> ValleDelCauca
            else              -> throw IllegalArgumentException()
        }
    }
}

data class Attribute (
    val id: ID,

    @SerializedName("value_id")
    val valueID: String? = null,

    @SerializedName("value_struct")
    val valueStruct: Struct? = null,

    val source: Long,
    val name: Name,

    @SerializedName("value_name")
    val valueName: String? = null,

    val values: List<AttributeValue>,

    @SerializedName("attribute_group_id")
    val attributeGroupID: AttributeGroupID,

    @SerializedName("attribute_group_name")
    val attributeGroupName: AttributeGroupName
)

enum class AttributeGroupID(val value: String) {
    Others("OTHERS");

    companion object {
        public fun fromValue(value: String): AttributeGroupID = when (value) {
            "OTHERS" -> Others
            else     -> throw IllegalArgumentException()
        }
    }
}

enum class AttributeGroupName(val value: String) {
    Otros("Otros");

    companion object {
        public fun fromValue(value: String): AttributeGroupName = when (value) {
            "Otros" -> Otros
            else    -> throw IllegalArgumentException()
        }
    }
}

enum class ID(val value: String) {
    AlphanumericModel("ALPHANUMERIC_MODEL"),
    Brand("BRAND"),
    DetailedModel("DETAILED_MODEL"),
    ItemCondition("ITEM_CONDITION"),
    Length("LENGTH"),
    Line("LINE"),
    Model("MODEL"),
    PackageLength("PACKAGE_LENGTH"),
    PackageWeight("PACKAGE_WEIGHT"),
    ProcessorBrand("PROCESSOR_BRAND"),
    ProcessorLine("PROCESSOR_LINE"),
    ProcessorModel("PROCESSOR_MODEL"),
    Weight("WEIGHT");

    companion object {
        public fun fromValue(value: String): ID = when (value) {
            "ALPHANUMERIC_MODEL" -> AlphanumericModel
            "BRAND"              -> Brand
            "DETAILED_MODEL"     -> DetailedModel
            "ITEM_CONDITION"     -> ItemCondition
            "LENGTH"             -> Length
            "LINE"               -> Line
            "MODEL"              -> Model
            "PACKAGE_LENGTH"     -> PackageLength
            "PACKAGE_WEIGHT"     -> PackageWeight
            "PROCESSOR_BRAND"    -> ProcessorBrand
            "PROCESSOR_LINE"     -> ProcessorLine
            "PROCESSOR_MODEL"    -> ProcessorModel
            "WEIGHT"             -> Weight
            else                 -> throw IllegalArgumentException()
        }
    }
}

enum class Name(val value: String) {
    CondiciónDelÍtem("Condición del ítem"),
    Largo("Largo"),
    LargoDelPaquete("Largo del paquete"),
    Línea("Línea"),
    LíneaDelProcesador("Línea del procesador"),
    Marca("Marca"),
    MarcaDelProcesador("Marca del procesador"),
    Modelo("Modelo"),
    ModeloAlfanumérico("Modelo alfanumérico"),
    ModeloDelProcesador("Modelo del procesador"),
    ModeloDetallado("Modelo detallado"),
    Peso("Peso"),
    PesoDelPaquete("Peso del paquete");

    companion object {
        public fun fromValue(value: String): Name = when (value) {
            "Condición del ítem"    -> CondiciónDelÍtem
            "Largo"                 -> Largo
            "Largo del paquete"     -> LargoDelPaquete
            "Línea"                 -> Línea
            "Línea del procesador"  -> LíneaDelProcesador
            "Marca"                 -> Marca
            "Marca del procesador"  -> MarcaDelProcesador
            "Modelo"                -> Modelo
            "Modelo alfanumérico"   -> ModeloAlfanumérico
            "Modelo del procesador" -> ModeloDelProcesador
            "Modelo detallado"      -> ModeloDetallado
            "Peso"                  -> Peso
            "Peso del paquete"      -> PesoDelPaquete
            else                    -> throw IllegalArgumentException()
        }
    }
}

data class Struct (
    val number: Double,
    val unit: Unit
)

enum class Unit(val value: String) {
    CM("cm"),
    G("g"),
    Kg("kg"),
    Mm("mm");

    companion object {
        public fun fromValue(value: String): Unit = when (value) {
            "cm" -> CM
            "g"  -> G
            "kg" -> Kg
            "mm" -> Mm
            else -> throw IllegalArgumentException()
        }
    }
}

data class AttributeValue (
    val id: String? = null,
    val name: String? = null,
    val struct: Struct? = null,
    val source: Long
)

enum class BuyingMode(val value: String) {
    BuyItNow("buy_it_now");

    companion object {
        public fun fromValue(value: String): BuyingMode = when (value) {
            "buy_it_now" -> BuyItNow
            else         -> throw IllegalArgumentException()
        }
    }
}



enum class Condition(val value: String) {
    New("new");

    companion object {
        public fun fromValue(value: String): Condition = when (value) {
            "new" -> New
            else  -> throw IllegalArgumentException()
        }
    }
}

enum class CurrencyID(val value: String) {
    Cop("COP");

    companion object {
        public fun fromValue(value: String): CurrencyID = when (value) {
            "COP" -> Cop
            else  -> throw IllegalArgumentException()
        }
    }
}

data class DifferentialPricing (
    val id: Long
)

enum class DomainID(val value: String) {
    McoAllInOneComputers("MCO-ALL_IN_ONE_COMPUTERS"),
    McoComputerMice("MCO-COMPUTER_MICE"),
    McoComputerMonitors("MCO-COMPUTER_MONITORS"),
    McoDesktopComputers("MCO-DESKTOP_COMPUTERS"),
    McoHardDrivesAndSsds("MCO-HARD_DRIVES_AND_SSDS"),
    McoMiniPcs("MCO-MINI_PCS"),
    McoNotebooks("MCO-NOTEBOOKS");

    companion object {
        public fun fromValue(value: String): DomainID = when (value) {
            "MCO-ALL_IN_ONE_COMPUTERS" -> McoAllInOneComputers
            "MCO-COMPUTER_MICE"        -> McoComputerMice
            "MCO-COMPUTER_MONITORS"    -> McoComputerMonitors
            "MCO-DESKTOP_COMPUTERS"    -> McoDesktopComputers
            "MCO-HARD_DRIVES_AND_SSDS" -> McoHardDrivesAndSsds
            "MCO-MINI_PCS"             -> McoMiniPcs
            "MCO-NOTEBOOKS"            -> McoNotebooks
            else                       -> throw IllegalArgumentException()
        }
    }
}

data class Installments (
    val quantity: Long,
    val amount: Double,
    val rate: Long,

    @SerializedName("currency_id")
    val currencyID: CurrencyID
)

enum class ListingTypeID(val value: String) {
    GoldPro("gold_pro"),
    GoldSpecial("gold_special");

    companion object {
        public fun fromValue(value: String): ListingTypeID = when (value) {
            "gold_pro"     -> GoldPro
            "gold_special" -> GoldSpecial
            else           -> throw IllegalArgumentException()
        }
    }
}

data class Prices (
    val id: String,
    val prices: List<Price>,
    val presentation: Presentation,
    @SerializedName("payment_method_prices")
    val paymentMethodPrices: List<Any?>,
    @SerializedName("reference_prices")
    val referencePrices: List<ReferencePrice>,
    @SerializedName("purchase_discounts")
    val purchaseDiscounts: List<Any?>
)

data class Presentation (
    @SerializedName("display_currency")
    val displayCurrency: CurrencyID
)

data class Price (
    val id: String,
    val type: PriceType,
    val amount: Double,
    @SerializedName("regular_amount")
    val regularAmount: Double? = null,
    @SerializedName("currency_id")
    val currencyID: CurrencyID,
    @SerializedName("last_updated")
    val lastUpdated: String,
    val conditions: Conditions,
    @SerializedName("exchange_rate_context")
    val exchangeRateContext: ExchangeRateContext,
    val metadata: Metadata
)

data class Conditions (
    @SerializedName("context_restrictions")
    val contextRestrictions: List<ContextRestriction>,
    @SerializedName("start_time")
    val startTime: String? = null,
    @SerializedName("end_time")
    val endTime: String? = null,
    val eligible: Boolean
)

enum class ContextRestriction(val value: String) {
    BuyerLoyalty3("buyer_loyalty_3"),
    BuyerLoyalty4("buyer_loyalty_4"),
    BuyerLoyalty5("buyer_loyalty_5"),
    BuyerLoyalty6("buyer_loyalty_6"),
    ChannelMarketplace("channel_marketplace"),
    ChannelMshops("channel_mshops");

    companion object {
        public fun fromValue(value: String): ContextRestriction = when (value) {
            "buyer_loyalty_3"     -> BuyerLoyalty3
            "buyer_loyalty_4"     -> BuyerLoyalty4
            "buyer_loyalty_5"     -> BuyerLoyalty5
            "buyer_loyalty_6"     -> BuyerLoyalty6
            "channel_marketplace" -> ChannelMarketplace
            "channel_mshops"      -> ChannelMshops
            else                  -> throw IllegalArgumentException()
        }
    }
}

enum class ExchangeRateContext(val value: String) {
    Default("DEFAULT");

    companion object {
        public fun fromValue(value: String): ExchangeRateContext = when (value) {
            "DEFAULT" -> Default
            else      -> throw IllegalArgumentException()
        }
    }
}

data class Metadata (
    @SerializedName("campaign_id")
    val campaignID: String? = null,
    @SerializedName("promotion_id")
    val promotionID: String? = null,
    @SerializedName("promotion_type")
    val promotionType: PromotionType? = null,
    @SerializedName("discount_meli_amount")
    val discountMeliAmount: Long? = null,
    @SerializedName("campaign_discount_percentage")
    val campaignDiscountPercentage: Double? = null,
    @SerializedName("campaign_end_date")
    val campaignEndDate: String? = null,
    @SerializedName("order_item_price")
    val orderItemPrice: Long? = null,
    @SerializedName("funding_mode")
    val fundingMode: String? = null
)

enum class PromotionType(val value: String) {
    Campaign("campaign"),
    Custom("custom"),
    MarketplaceCampaign("marketplace_campaign");

    companion object {
        public fun fromValue(value: String): PromotionType = when (value) {
            "campaign"             -> Campaign
            "custom"               -> Custom
            "marketplace_campaign" -> MarketplaceCampaign
            else                   -> throw IllegalArgumentException()
        }
    }
}

enum class PriceType(val value: String) {
    Promotion("promotion"),
    Standard("standard");

    companion object {
        public fun fromValue(value: String): PriceType = when (value) {
            "promotion" -> Promotion
            "standard"  -> Standard
            else        -> throw IllegalArgumentException()
        }
    }
}

data class ReferencePrice (
    val id: String,
    val type: ReferencePriceType,
    val conditions: Conditions,
    val amount: Double,
    @SerializedName("currency_id")
    val currencyID: CurrencyID,
    @SerializedName("exchange_rate_context")
    val exchangeRateContext: ExchangeRateContext,
    val tags: List<Any?>,
    @SerializedName("last_updated")
    val lastUpdated: String
)

enum class ReferencePriceType(val value: String) {
    MinStandard("min_standard");
    companion object {
        public fun fromValue(value: String): ReferencePriceType = when (value) {
            "min_standard" -> MinStandard
            else           -> throw IllegalArgumentException()
        }
    }
}

data class Seller (
    val id: Long,
    val permalink: Any? = null,
    @SerializedName("registration_date")
    val registrationDate: Any? = null,
    @SerializedName("car_dealer")
    val carDealer: Boolean,
    @SerializedName("real_estate_agency")
    val realEstateAgency: Boolean,
    val tags: Any? = null
)

data class SellerAddress (
    val id: String,
    val comment: String,
    @SerializedName("address_line")
    val addressLine: String,
    @SerializedName("zip_code")
    val zipCode: String,
    val country: Sort,
    val state: Sort,
    val city: Sort,
    val latitude: String,
    val longitude: String
)

data class Shipping (
    @SerializedName("free_shipping")
    val freeShipping: Boolean,
    val mode: Mode,
    val tags: List<ShippingTag>,
    @SerializedName("logistic_type")
    val logisticType: LogisticType,
    @SerializedName("store_pick_up")
    val storePickUp: Boolean
)

enum class LogisticType(val value: String) {
    CrossDocking("cross_docking"),
    DropOff("drop_off"),
    Fulfillment("fulfillment"),
    XdDropOff("xd_drop_off");

    companion object {
        public fun fromValue(value: String): LogisticType = when (value) {
            "cross_docking" -> CrossDocking
            "drop_off"      -> DropOff
            "fulfillment"   -> Fulfillment
            "xd_drop_off"   -> XdDropOff
            else            -> throw IllegalArgumentException()
        }
    }
}

enum class Mode(val value: String) {
    Me2("me2");

    companion object {
        public fun fromValue(value: String): Mode = when (value) {
            "me2" -> Me2
            else  -> throw IllegalArgumentException()
        }
    }
}

enum class ShippingTag(val value: String) {
    Fulfillment("fulfillment"),
    MandatoryFreeShipping("mandatory_free_shipping"),
    SelfServiceIn("self_service_in"),
    SelfServiceOut("self_service_out");

    companion object {
        public fun fromValue(value: String): ShippingTag = when (value) {
            "fulfillment"             -> Fulfillment
            "mandatory_free_shipping" -> MandatoryFreeShipping
            "self_service_in"         -> SelfServiceIn
            "self_service_out"        -> SelfServiceOut
            else                      -> throw IllegalArgumentException()
        }
    }
}

enum class SiteID(val value: String) {
    Mco("MCO");

    companion object {
        public fun fromValue(value: String): SiteID = when (value) {
            "MCO" -> Mco
            else  -> throw IllegalArgumentException()
        }
    }
}

enum class ResultTag(val value: String) {
    BestSellerCandidate("best_seller_candidate"),
    CartEligible("cart_eligible"),
    CatalogListingEligible("catalog_listing_eligible"),
    GoodQualityPicture("good_quality_picture"),
    GoodQualityThumbnail("good_quality_thumbnail"),
    ImmediatePayment("immediate_payment"),
    IncompleteTechnicalSpecs("incomplete_technical_specs"),
    LoyaltyDiscountEligible("loyalty_discount_eligible"),
    MeliChoiceCandidate("meli_choice_candidate"),
    ModerationPenalty("moderation_penalty"),
    PoorQualityPicture("poor_quality_picture"),
    PoorQualityThumbnail("poor_quality_thumbnail"),
    ShippingGuaranteed("shipping_guaranteed"),
    StandardPriceByChannel("standard_price_by_channel");

    companion object {
        public fun fromValue(value: String): ResultTag = when (value) {
            "best_seller_candidate"      -> BestSellerCandidate
            "cart_eligible"              -> CartEligible
            "catalog_listing_eligible"   -> CatalogListingEligible
            "good_quality_picture"       -> GoodQualityPicture
            "good_quality_thumbnail"     -> GoodQualityThumbnail
            "immediate_payment"          -> ImmediatePayment
            "incomplete_technical_specs" -> IncompleteTechnicalSpecs
            "loyalty_discount_eligible"  -> LoyaltyDiscountEligible
            "meli_choice_candidate"      -> MeliChoiceCandidate
            "moderation_penalty"         -> ModerationPenalty
            "poor_quality_picture"       -> PoorQualityPicture
            "poor_quality_thumbnail"     -> PoorQualityThumbnail
            "shipping_guaranteed"        -> ShippingGuaranteed
            "standard_price_by_channel"  -> StandardPriceByChannel
            else                         -> throw IllegalArgumentException()
        }
    }
}
