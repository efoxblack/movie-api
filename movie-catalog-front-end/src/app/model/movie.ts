import { Genre } from './genre.enum';
import { Rating } from './rating.enum';

export class Movie {

    public id: number;
    public title: string;
    public description: string;
    public recommended: boolean;
    public cast: string;
    public genre: Genre;
    public rating: Rating;
    public userRating: number;

}
