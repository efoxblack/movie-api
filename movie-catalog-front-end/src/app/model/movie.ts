import { Genre } from './genre.enum';

export class Movie {

    public id: number;
    public title: string;
    public description: string;
    public recommended: boolean;
    public genre: Genre;
    public userRating: number;

}
