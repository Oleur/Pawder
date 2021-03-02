/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import javax.inject.Inject

class PetRepository @Inject constructor() {

    fun getPets() = pets

    fun getPet(id: Int): Pet? = pets.find { it.id == id }

    companion object {
        private val pets = listOf(
            Pet(
                id = 0,
                name = "Alpha",
                desc = "Huskies are energetic and athletic. They usually have a thick double coat that can be gray, black," +
                    "copper red, or white. The double coat generally protects huskies against harsh winters and," +
                    "contrary to what most believe, they can survive in hotter climates. During the hotter climates," +
                    "huskies tend to shed their undercoat regularly to cool their bodies. In addition to shedding," +
                    "huskies control their eating habits based on the season; in cooler climates, they tend to eat" +
                    "generous amounts, causing their digestion to generate heat, whilst in warmer climates, they eat" +
                    "less Their eyes are typically pale blue, although they may also be brown, green, blue, yellow," +
                    "or  heterochromic . Huskies are more prone to some degree of  uveitis  than most other" +
                    "breeds. Hunting instincts can still be found in some of this breed today.",
                imageUrl = "https://images.pexels.com/photos/3726314/pexels-photo-3726314.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 2,
                breed = "Husky",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 60
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 90
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 70
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 70
                    ),
                    PetInfo(
                        category = "Style",
                        value = 60
                    )
                )
            ),
            Pet(
                id = 1,
                name = "Banjo",
                desc = "Labradors have a reputation as a very even-tempered breed and an excellent family dog. This" +
                    "includes a good reputation with children of all ages and other animals. Some lines, particularly" +
                    "those that have continued to be bred specifically for their skills at working in the field (rather than" +
                    "for their appearance), are particularly fast and athletic. Their fun-loving boisterousness and lack" +
                    "of fear may require training and intelligent handling at times to ensure it does not get out of" +
                    "hand—an uncontrolled adult can be quite problematic. Females may be slightly more" +
                    "independent than males. Labradors mature at around three years of age; before this time they" +
                    "can have a significant degree of puppy-like energy, often mislabelled as" +
                    "being hyperactive. Because of their enthusiasm, leash-training early on is suggested to prevent" +
                    "pulling when full-grown. Labradors often enjoy retrieving a ball endlessly (often obsessively) and" +
                    "other forms of activity (such as agility, frisbee, or  flyball ).",
                imageUrl = "https://images.pexels.com/photos/3860304/pexels-photo-3860304.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 3,
                breed = "Labrador",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 80
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 90
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 70
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 45
                    ),
                    PetInfo(
                        category = "Style",
                        value = 60
                    )
                )
            ),
            Pet(
                id = 2,
                name = "Carlos",
                desc = "According to the American Kennel Club (AKC), a Bulldog&#39;s disposition should be &quot;equable and" +
                    "kind, resolute, and courageous (not vicious or aggressive), and demeanor should be pacifist and" +
                    "dignified. These attributes should be countenanced by the expression and behavior&quot;." +
                    "Breeders have worked to reduce/remove aggression from these dogs. Most have a friendly," +
                    "patient, but stubborn nature. Bulldogs are recognized as excellent family pets because of their" +
                    "tendency to form strong bonds with children." +
                    "Generally, Bulldogs are known for getting along well with children, other dogs, and other pets.",
                imageUrl = "https://images.pexels.com/photos/5883460/pexels-photo-5883460.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 1,
                breed = "Bulldog",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 80
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 40
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 30
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 20
                    ),
                    PetInfo(
                        category = "Style",
                        value = 70
                    )
                )
            ),
            Pet(
                id = 3,
                name = "Raymond",
                desc = "Cockers are compassionate, determined, kind, intelligent, athletic, alert and resilient and make" +
                    "great family pets. The breed does not like being alone, and will bond strongly to an individual" +
                    "person in a family, usually the one who feeds it. Known for optimism, intelligence and adaptability," +
                    "the breed is extremely loyal and affectionate. The English Cocker Spaniel has a cheerful" +
                    "nature. Due to the breed&#39;s happy disposition and continuously wagging tail, it has been given the" +
                    "nickname &quot;merry cocker&quot;. They can also be dominant but loyal to their companion.\n" +
                    "With a good level of socialisation at an early age, Cocker Spaniels can get along well with people," +
                    "children, other dogs and other pets. This breed seems to have a perpetually wagging tail and" +
                    "prefers to be around people; it is not best suited to the backyard alone. Cockers can be easily" +
                    "stressed by loud noises and by rough treatment or handling. When trained with a soft hand and" +
                    "plentiful rewards, the Cocker Spaniel will be an obedient and loving companion with a happy," +
                    "cheerful nature.",
                imageUrl = "https://images.pexels.com/photos/3976279/pexels-photo-3976279.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 18,
                breed = "Cocker",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 98
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 78
                    ),
                    PetInfo(
                        category = "Style",
                        value = 60
                    )
                )
            ),
            Pet(
                id = 4,
                name = "Mavrix",
                desc = "The breed is highly affectionate, playful, extremely patient and eager to please. As such, dogs of" +
                    "the breed are good with children and other dogs. Cavaliers are not shy about socializing with" +
                    "much larger dogs. They will adapt quickly to almost any environment, family, and location and suit" +
                    "city and country life. Their ability to bond with larger and smaller dogs makes them ideal in" +
                    "houses with more than one breed of dog as long as the other dog is trained. Cavaliers rank 44th" +
                    "in Stanley Coren&#39;s The Intelligence of Dogs, being of average intelligence in working or" +
                    "obedience. Cavaliers are naturally curious and playful, but also enjoy simply cuddling up on a" +
                    "cushion or lap, making them excellent companion or lap dogs for medical patients and the elderly.\n" +
                    "Cavaliers are active and sporting. Cavaliers are successful in conformation shows, obedience" +
                    "and agility and they also make wonderful therapy dogs due to their sweet, gentle natures. The" +
                    "breed is adaptable in their need for exercise, happy with either sleeping on the couch or taking" +
                    "long walks.\n" +
                    "They have an instinct to chase most things that move including vehicles on busy streets, and so" +
                    "most Cavaliers will never become &quot;street-wise&quot;",
                imageUrl = "https://images.pexels.com/photos/1390361/pexels-photo-1390361.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 48,
                breed = "Cavalier King Charles",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 100
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 60
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 70
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 60
                    ),
                    PetInfo(
                        category = "Style",
                        value = 35
                    )
                )
            ),
            Pet(
                id = 5,
                name = "Jungle",
                desc = "Pembroke Welsh Corgis love to be involved in the family, and tend to follow wherever their" +
                    "owners go. They have a great desire to please their owners, thus making them eager to learn and" +
                    "train. The dogs can also be challenging to train due to their working background, stubbornness" +
                    "and intelligence - they were ranked as the eleventh most intelligent dog in Stanley Coren&#39;s The" +
                    "Intelligence of Dogs. Besides herding, they also function as watchdogs due to their alertness and" +
                    "tendency to bark, which can be aggravated if they are not stimulated adequately. Most" +
                    "Pembrokes will seek the attention of everyone they meet and behave well around children and" +
                    "other pets. It is important to socialize this breed with other animals, adults, and children when" +
                    "they are very young to avoid any anti-social behaviour or aggression later in life. Due to their" +
                    "herding and - for some - prey instinct, they love to chase anything that moves, so it is best to" +
                    "keep them inside fenced areas. The herding instinct will also cause some younger Pembrokes to" +
                    "nip at their owners&#39; ankles as this is what they were bred to do with cattle",
                imageUrl = "https://images.pexels.com/photos/2664417/pexels-photo-2664417.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 1,
                breed = "Corgi",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 30
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 50
                    ),
                    PetInfo(
                        category = "Style",
                        value = 100
                    )
                )
            ),
            Pet(
                id = 6,
                name = "Barney",
                desc = "Shar-Pei mostly enjoys life as a beloved companion. They can even adapt to apartment life." +
                    "However, your neighbors might not appreciate your pooch’s barking tendencies. Novice pet parents" +
                    "should beware, as these dogs need plenty of firm, consistent training, which won’t be easy with their" +
                    "natural stubborn tendencies. Early socialization will go a long way. If you can meet the breed’s needs," +
                    "you’ll have a protective watchdog and a loyal best friend. They like to be alone and independant," +
                    "don’t go along well with other dogs, but they are protective and caring for their breeders.",
                imageUrl = "https://images.pexels.com/photos/4588030/pexels-photo-4588030.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
                age = 4,
                breed = "Shar Pei",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 40
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 30
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 30
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 65
                    ),
                    PetInfo(
                        category = "Style",
                        value = 95
                    )
                )
            ),
            Pet(
                id = 7,
                name = "Damian",
                desc = "The roles of this breed are as varied as their reputed ancestors. They were used as  hunting" +
                    "dogs ,  dogs of war , guarding the borders of Dalmatia. To this day, the breed retains a high" +
                    "guarding instinct; although friendly and loyal to those the dog knows and trusts, it is often aloof" +
                    "with strangers and unknown dogs. Dalmatians have a strong hunting instinct and are an excellent" +
                    "exterminator of rats and vermin. In sporting, they have been used as bird dogs, trail hounds," +
                    "retrievers, or in packs for wild boar or stag hunting. Their dramatic markings and intelligence have" +
                    "made them successful circus dogs throughout the years.",
                imageUrl = "https://images.pexels.com/photos/3763313/pexels-photo-3763313.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
                age = 2,
                breed = "Dalmatian",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 70
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 100
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 35
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 25
                    ),
                    PetInfo(
                        category = "Style",
                        value = 95
                    )
                )
            ),
            Pet(
                id = 8,
                name = "Hector",
                desc = "The temperament of the Golden Retriever is a hallmark of the breed, and is described in the" +
                    "standard as &quot;kindly, friendly and confident&quot;.Golden Retrievers make good family pets, particularly" +
                    "as they are patient with children They are not &quot;one-man dogs&quot; and are generally equally amiable" +
                    "with both strangers and those familiar to them. Their trusting, gentle disposition makes them a" +
                    "poor  guard dog . Any form of unprovoked  aggression  or hostility towards either people,  dogs  or" +
                    "other animals, whether in the show ring or community, is considered unacceptable in a Golden" +
                    "Retriever and is not in keeping with the character of the breed, nor should a Golden Retriever be" +
                    "unduly timid or nervous The typical Golden Retriever is calm, naturally intelligent and biddable," +
                    "and with an exceptional eagerness to please.\n" +
                    "Typical Golden Retrievers are active and fun-loving animals with the exceptionally patient" +
                    "demeanour befitting a dog bred to sit quietly for hours in a  hunting blind . Adult Goldens love to" +
                    "work, and have a keen ability to focus on a given task. They will work until they collapse, so care" +
                    "should be taken to avoid overworking them.",
                imageUrl = "https://images.pexels.com/photos/4130054/pexels-photo-4130054.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 23,
                breed = "Golden Retriever",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 100
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 80
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 90
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 75
                    ),
                    PetInfo(
                        category = "Style",
                        value = 60
                    )
                )
            ),
            Pet(
                id = 9,
                name = "Fritz",
                desc = "This breed is often described by the phrase \"much in little\" or \"a lot of dog in a small space\", alluding to the Pug's remarkable and charming personality, despite its small size. Pugs are strong willed but rarely aggressive, and are suitable for families with children. The majority of the breed is very fond of children and sturdy enough to properly play with them. Depending on their owner's mood, they can be quiet and docile but also vivacious and teasing. Pugs tend to be intuitive and sensitive to the moods of their owners and are usually eager to please them. Pugs are playful and thrive on human companionship. They also tend to have a snoozy nature and spend a lot of time napping. Pugs are often called \"shadows\" because they follow their owners around and like to stay close to the action, craving attention and affection from their owners.",
                imageUrl = "https://images.pexels.com/photos/374898/pexels-photo-374898.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 32,
                breed = "Pug",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 100
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 50
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 40
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 30
                    ),
                    PetInfo(
                        category = "Style",
                        value = 5
                    )
                )
            ),
            Pet(
                id = 10,
                name = "Edou",
                desc = "Dogs (Canis lupus familiaris) are domesticated mammals, not natural wild animals. They were originally bred from wolves. They have been bred by humans for a long time, and were the first animals ever to be domesticated. ... They are a popular pet because they are usually playful, friendly, loyal and listen to humans.",
                imageUrl = "https://images.pexels.com/photos/3361739/pexels-photo-3361739.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
                age = 43,
                breed = "Shi Tzu",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 90
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 50
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 65
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 65
                    ),
                    PetInfo(
                        category = "Style",
                        value = 50
                    )
                )
            ),
            Pet(
                id = 11,
                name = "Chouki",
                desc = "The Shiba is a relatively fastidious breed and feels the need to maintain itself in a clean state. They can often be seen licking their paws and legs, much as cats do. They generally go out of their way to keep their coats clean. Because of their fastidious and proud nature, Shiba puppies are easy to housebreak and in many cases will housebreak themselves. Having their owner simply place them outside after meal times and naps is generally enough to teach the Shiba the appropriate method of toileting.",
                imageUrl = "https://images.pexels.com/photos/6588923/pexels-photo-6588923.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                age = 12,
                breed = "Shiba",
                infoList = arrayListOf(
                    PetInfo(
                        category = "Kindness",
                        value = 70
                    ),
                    PetInfo(
                        category = "Activity",
                        value = 60
                    ),
                    PetInfo(
                        category = "Healthy",
                        value = 70
                    ),
                    PetInfo(
                        category = "Fluffiness",
                        value = 80
                    ),
                    PetInfo(
                        category = "Style",
                        value = 80
                    )
                )
            )
        )
    }
}
